using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using Demo1.Infraestrutura.Repositorios;
using Demo1.Dominio.Entidades;

namespace Demo1WebAPI.Controllers
{
    public class PedidosController : ApiController
    {
        private PedidoRepositorio repositorio = new PedidoRepositorio();

        public IHttpActionResult Post(Pedido pedido)
        {
            List<string> listaErros;
            if (!pedido.Validar(out listaErros))
            {
                return BadRequest(string.Join(".\n", listaErros.ToArray()));
            }
            repositorio.Criar(pedido);
            return Ok(pedido);
        }

        public IHttpActionResult Put(Pedido pedido)
        {
            List<string> listaErros;
            if (!pedido.Validar(out listaErros))
            {
                return BadRequest(string.Join(".\n", listaErros.ToArray()));
            }
            repositorio.Alterar(pedido);
            return Ok(pedido);
        }
    }
}
