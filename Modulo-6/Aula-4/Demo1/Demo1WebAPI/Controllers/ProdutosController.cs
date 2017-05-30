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
        private ProdutoRepositorio repositorio = new ProdutoRepositorio();

        public IHttpActionResult Post(Produto produto)
        {
            List<string> listaErros;
            if (!produto.validar(out listaErros))
            {
                return BadRequest(string.Join(".\n", listaErros.ToArray()));
            }
            repositorio.Criar(produto);
            return Ok(produto);
        }

        public IHttpActionResult Get()
        {
            return Ok(repositorio.Listar());
        }

        public IHttpActionResult Get(int id)
        {
            return Ok(repositorio.Obter(id));
        }

        public IHttpActionResult Delete(int id)
        {
            repositorio.Excluir(id);
            return Ok();
        }

        public IHttpActionResult Put(Produto produto)
        {
            List<string> listaErros;
            if (!produto.validar(out listaErros))
            {
                return BadRequest(string.Join(".\n", listaErros.ToArray()));
            }
            repositorio.Alterar(produto);
            return Ok(produto);
        }
    }
}