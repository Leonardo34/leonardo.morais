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
    [RoutePrefix("api/adicionais")]
    public class AdicionaisController : ApiController
    {
        private AdicionalRepositorio repositorio = new AdicionalRepositorio();

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
            var adicional = repositorio.ObterPorId(id);
            if (adicional == null)
            {
                return Request.CreateResponse(HttpStatusCode.NotFound,
                   new { error = "Não existe adicional com o id informado" });
            }
            return Request.CreateResponse(HttpStatusCode.OK, new { data = adicional });
        }

        [AutenticacaoBasic64]
        [HttpPost]
        public IHttpActionResult Post(Adicional adicional)
        {
            repositorio.Criar(adicional);
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
        public IHttpActionResult Alterar(Adicional adicional)
        {
            repositorio.Alterar(adicional);
            return Ok();
        }
    }
}
