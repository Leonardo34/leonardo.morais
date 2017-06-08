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
    [RoutePrefix("api/imoveis")]
    public class ImoveisController : ApiController
    {
        private ImovelRepositorio repositorio = new ImovelRepositorio();
        private EstoqueImovelRepositorio estoqueRepositorio = new EstoqueImovelRepositorio();

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
            var imovel = repositorio.ObterPorId(id);
            if (imovel == null)
            {
                return Request.CreateResponse(HttpStatusCode.NotFound,
                   new { error = "Não existe imovel com o id informado" });
            }
            return Request.CreateResponse(HttpStatusCode.OK, new { data = imovel });
        }

        [AutenticacaoBasic64]
        [HttpPost]
        public IHttpActionResult Post(Imovel imovel)
        {
            repositorio.Criar(imovel);
            return Ok();
        }

        [AutenticacaoBasic64]
        [Route("estoque")]
        [HttpPost]
        public IHttpActionResult PostEstoque(EstoqueImovel estoque)
        {
            estoqueRepositorio.Criar(estoque);
            return Ok();
        }

        [AutenticacaoBasic64]
        [Route("estoque/{id:int}")]
        [HttpDelete]
        public IHttpActionResult DeleteEstoque(int id)
        {
            estoqueRepositorio.Deletar(id);
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
        public IHttpActionResult Alterar(Imovel imovel)
        {
            repositorio.Alterar(imovel);
            return Ok();
        }
    }
}
