using EditoraCrescer.Infraestrutura.Contexto;
using EditoraCrescer.Infraestrutura.Entidades;
using EditoraCrescer.Infraestrutura.Repositorios;
using EditoraCrescer.WebAPI.App_Start;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace EditoraCrescer.WebAPI.Controllers
{
    [RoutePrefix("api/Livros")]
    public class LivrosController : ApiController
    {
        private LivroRepositorio repositorio = new LivroRepositorio();

        [HttpGet]
        public HttpResponseMessage Get(int skip, int take)
        {
            return Request.CreateResponse(HttpStatusCode.OK,
                new { data = repositorio.Listar(skip, take) });
        }

        [Route("{isbn:int}")]
        [HttpGet]
        public HttpResponseMessage ObterLivroPeloIsbn(int isbn)
        {
            var livro = repositorio.ObterPorIsbn(isbn);
            if (livro == null)
            {
                return Request.CreateResponse(HttpStatusCode.NotFound,
                    new { error = "Não existe livro com o id informado" });
            }
            return Request.CreateResponse(HttpStatusCode.OK, new { data = livro });
        }

        [Route("{genero}")]
        [HttpGet]
        public HttpResponseMessage ObterLivrosPorGenero(string genero)
        {
            return Request.CreateResponse(HttpStatusCode.OK, new { data = 
                repositorio.ObterPorGenero(genero) });
        }

        [Route("lancamentos")]
        [HttpGet]
        public HttpResponseMessage ObterLancamentos()
        {
            return Request.CreateResponse(HttpStatusCode.OK, new
            {
                data = repositorio.ListarLancamentos()
            });
        }

        [Route("todosLivros")]
        [HttpGet]
        public HttpResponseMessage ObterTodosLivros()
        {
            return Request.CreateResponse(HttpStatusCode.OK, new
            {
                data =
                repositorio.ListarTodosLivros()
            });
        }

        [AutenticacaoBasic64]
        [HttpPost]
        public IHttpActionResult Post(Livro livro)
        {
            repositorio.Salvar(livro);
            return Ok();
        }

        [AutenticacaoBasic64]
        [HttpDelete]
        public IHttpActionResult Delete(int id)
        {
            return Ok(repositorio.Excluir(id));
        }

        [Route("publicar/{isbn:int}")]
        [AutenticacaoBasic64]
        [HttpPost]
        public IHttpActionResult PublicarLivro(int isbn)
        {
            repositorio.Publicar(isbn);
            return Ok();
        }
    }
}
