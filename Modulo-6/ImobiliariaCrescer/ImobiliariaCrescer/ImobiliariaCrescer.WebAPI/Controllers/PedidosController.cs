using ImobiliariaCrescer.Infraestrutura.Entidades;
using ImobiliariaCrescer.Infraestrutura.Repositorios;
using ImobiliariaCrescer.WebAPI.App_Start;
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
        [HttpPost]
        public IHttpActionResult Post(Pedido pedido)
        {
            repositorio.Criar(pedido);
            return Ok();
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
