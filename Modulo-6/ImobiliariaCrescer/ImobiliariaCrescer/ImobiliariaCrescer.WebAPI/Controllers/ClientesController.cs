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
    [RoutePrefix("api/clientes")]
    public class ClientesController : ApiController
    {
        private ClienteRepositorio repositorio = new ClienteRepositorio();

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
            var cliente = repositorio.ObterPorId(id);
            if (cliente == null)
            {
                return Request.CreateResponse(HttpStatusCode.NotFound,
                   new { error = "Não existe cliente com o id informado" });
            }
            return Request.CreateResponse(HttpStatusCode.OK, new { data = cliente });
        }

        [AutenticacaoBasic64]
        [HttpGet]
        public HttpResponseMessage GetByCpf(string cpf)
        {
            var cliente = repositorio.ObterPorCpf(cpf);
            if (cliente == null)
            {
                return Request.CreateResponse(HttpStatusCode.NotFound,
                   new { error = "Não existe cliente com o id informado" });
            }
            return Request.CreateResponse(HttpStatusCode.OK, new { data = cliente });
        }

        [AutenticacaoBasic64]
        [HttpPost]
        public IHttpActionResult Post(Cliente cliente)
        {
            if (repositorio.ObterPorCpf(cliente.Cpf) != null)
            {
                return BadRequest("Já existe cliente com este CPF cadastrado no sistema");
            }
            repositorio.Criar(cliente);
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
        public IHttpActionResult Alterar(Cliente cliente)
        {
            repositorio.Alterar(cliente);
            return Ok();
        }
    }
}
