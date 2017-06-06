using ImobiliariaCrescer.Infraestrutura.ContextoEntity;
using ImobiliariaCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ImobiliariaCrescer.Infraestrutura.Repositorios
{
    public class PedidoAdicionalRepositorio : IRepositorio<PedidoAdicional>
    {
        private Contexto contexto = new Contexto();

        public void Alterar(PedidoAdicional objeto)
        {
            contexto.Entry(objeto).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();
        }

        public void Criar(PedidoAdicional objeto)
        {
            contexto.PedidosAdicionais.Add(objeto);
            contexto.SaveChanges();
        }

        public void Deletar(int id)
        {
            var pedidoAdicionalDeletado = ObterPorId(id);
            contexto.PedidosAdicionais.Remove(pedidoAdicionalDeletado);
            contexto.SaveChanges();
        }

        public List<PedidoAdicional> Listar()
        {
            return contexto.PedidosAdicionais.ToList();
        }

        public PedidoAdicional ObterPorId(int id)
        {
            return contexto.PedidosAdicionais.FirstOrDefault(p => p.Id == id);
        }
    }
}
