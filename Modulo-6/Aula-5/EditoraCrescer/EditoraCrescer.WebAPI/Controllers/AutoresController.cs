using EditoraCrescer.Infraestrutura.Entidades;
using EditoraCrescer.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace EditoraCrescer.WebAPI.Controllers
{
    public class AutoresController : ApiController
    {
        private AutorRepositorio repositorio = new AutorRepositorio();

        [HttpGet]
        public HttpResponseMessage Get()
        {
            return Request.CreateResponse(HttpStatusCode.OK, 
                new { data = repositorio.Listar() });
        }

        [HttpPost]
        public IHttpActionResult Post(Autor autor)
        {
            repositorio.Salvar(autor);
            return Ok(new { data = autor });
        }

        [HttpDelete]
        public IHttpActionResult Delete(int id)
        {
            return Ok(repositorio.Excluir(id));
        }
    }
}
