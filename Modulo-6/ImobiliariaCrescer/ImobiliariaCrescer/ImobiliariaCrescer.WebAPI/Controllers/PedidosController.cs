using ImobiliariaCrescer.Infraestrutura.Entidades;
using ImobiliariaCrescer.Infraestrutura.Repositorios;
using ImobiliariaCrescer.WebAPI.App_Start;
using ImobiliariaCrescer.WebAPI.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace ImobiliariaCrescer.WebAPI.Controllers
{
    [RoutePrefix("api/pedidos")]
    public class PedidosController : ApiController
    {
        private PedidoRepositorio repositorio = new PedidoRepositorio();
        private ImovelRepositorio repositorioImoveis = new ImovelRepositorio();
        private ClienteRepositorio repositorioClientes = new ClienteRepositorio();
        private ComboRepositorio repositorioCombos = new ComboRepositorio();
        private AdicionalRepositorio repositorioAdicionais = new AdicionalRepositorio();
        private EstoqueImovelRepositorio repositorioEstoque = new EstoqueImovelRepositorio();

        [AutenticacaoBasic64]
        [HttpGet]
        public HttpResponseMessage Get()
        {
            return Request.CreateResponse(HttpStatusCode.OK,
                new { data = repositorio.Listar() });
        }

        [AutenticacaoBasic64]
        [Route("{id:int}")]
        [HttpGet]
        public HttpResponseMessage GetById(int id)
        {
            var pedido = repositorio.ObterPorId(id);
            if (pedido == null)
            {
                return Request.CreateResponse(HttpStatusCode.NotFound,
                   new { error = "Não existe pedido com o id informado" });
            }
            return Request.CreateResponse(HttpStatusCode.OK, new { data = pedido });
        }

        [AutenticacaoBasic64]
        [Route("cliente/{idCliente:int}")]
        [HttpGet]
        public HttpResponseMessage GetPedidosEmAbertoByCliente(int idCliente)
        {
            var pedidos = repositorio.BuscarPedidosAbertosCliente(idCliente);
            return Request.CreateResponse(HttpStatusCode.OK, new { data = pedidos });
        }

        [AutenticacaoBasic64]
        [Route("relatorio")]
        [HttpGet]
        public HttpResponseMessage GetRelatorioMensal()
        {
            return Request.CreateResponse(HttpStatusCode.OK, 
                new { data = repositorio.BuscarRelatorioMensal() });
        }

        [AutenticacaoBasic64]
        [HttpPost]
        public IHttpActionResult Post(PedidoModel pedidoModel)
        {
            var imovel = repositorioImoveis.ObterPorId(pedidoModel.Imovel.Id);
            var combo = repositorioCombos.ObterPorId(pedidoModel.Combo.Id);
            var cliente = repositorioClientes.ObterPorId(pedidoModel.Cliente.Id);
            repositorioEstoque.RetirarImovelEstoque(imovel.Id, combo.Id);

            var pedido = new Pedido()
            {
                Imovel = imovel,
                Combo = combo,
                Cliente = cliente,
                DataVenda = DateTime.Now,
                DataEntregaPrevista = DateTime.Now.AddDays(pedidoModel.DiasAluguel),
                Adicionais = new List<PedidoAdicional>()
            };
            foreach (var adicional in pedidoModel.Adicionais)
            {
                var adc = repositorioAdicionais.ObterPorId(adicional.Id);
                pedido.Adicionais.Add(new PedidoAdicional()
                {
                    Adicional = adc,
                    Pedido = pedido,
                    Quantidade = 1
                });
                adc.Quantidade -= 1;
                repositorioAdicionais.Alterar(adc);
            }
            pedido.CalcularPrecoLocacao();
            repositorio.Criar(pedido);
            return Ok();
        }

        [AutenticacaoBasic64]
        [Route("devolver/{id:int}")]
        [HttpPost]
        public HttpResponseMessage DevolverImovel(int id)
        {
            var pedido = repositorio.ObterPorId(id);
            if (pedido.DataEntregaRealizada != null)
            {
                return Request.CreateResponse(HttpStatusCode.NotFound,
                   new { error = "Não existe pedido com o id informado" });
            }
            pedido.DataEntregaRealizada = DateTime.Now;
            pedido.CalcularPrecoTotal();
            repositorioEstoque.AdicionarImovelEstoque(pedido.Imovel.Id, pedido.Combo.Id);
            foreach (var adicional in pedido.Adicionais)
            {
                adicional.Adicional.Quantidade += 1;
                repositorioAdicionais.Alterar(adicional.Adicional);
            }
            repositorio.Alterar(pedido);
            return Request.CreateResponse(HttpStatusCode.OK, new { data = pedido.TotalPago });
        }

        [AutenticacaoBasic64]
        [Route("{id:int}")]
        [HttpDelete]
        public IHttpActionResult Delete(int id)
        {
            repositorio.Deletar(id);
            return Ok();
        }

        [AutenticacaoBasic64]
        [HttpPut]
        public IHttpActionResult Alterar(Pedido pedido)
        {
            repositorio.Alterar(pedido);
            return Ok();
        }
    }
}
