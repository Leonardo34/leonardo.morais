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
    [RoutePrefix("api/combos")]
    public class CombosController : ApiController
    {
        private ComboRepositorio repositorio = new ComboRepositorio();

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
            var combo = repositorio.ObterPorId(id);
            if (combo == null)
            {
                return Request.CreateResponse(HttpStatusCode.NotFound,
                   new { error = "Não existe combo com o id informado" });
            }
            return Request.CreateResponse(HttpStatusCode.OK, new { data = combo });
        }

        [AutenticacaoBasic64]
        [HttpPost]
        public IHttpActionResult Post(Combo combo)
        {
            repositorio.Criar(combo);
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
        public IHttpActionResult Alterar(Combo combo)
        {
            repositorio.Alterar(combo);
            return Ok();
        }
    }
}
