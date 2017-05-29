using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using Demo1.Dominio.Entidades;
using Demo1.Infraestrutura.Repositorios;

namespace Demo1WebAPI.Controllers
{
    public class ProdutosController : ApiController
    {
        private ProdutoRepositorio ProdutosRepositorio = new ProdutoRepositorio();

        public IHttpActionResult Post(Produto produto)
        {
            List<string> listaErros;
            if (!produto.validar(out listaErros))
            {
                return BadRequest(string.Join(".", listaErros.ToArray()));
            }
            ProdutosRepositorio.Criar(produto);
            return Ok(produto);
        }
    }
}