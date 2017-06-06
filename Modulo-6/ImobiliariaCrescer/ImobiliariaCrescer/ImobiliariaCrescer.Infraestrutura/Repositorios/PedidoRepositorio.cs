using ImobiliariaCrescer.Infraestrutura.ContextoEntity;
using ImobiliariaCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ImobiliariaCrescer.Infraestrutura.Repositorios
{
    public class PedidoRepositorio : IRepositorio<Pedido>
    {
        private Contexto contexto = new Contexto();
        
        public void Alterar(Pedido objeto)
        {
            contexto.Entry(objeto).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();
        }

        public void Criar(Pedido objeto)
        {
            contexto.Pedidos.Add(objeto);
            contexto.SaveChanges();
        }

        public void Deletar(int id)
        {
            var pedidoDeletar = ObterPorId(id);
            contexto.Pedidos.Remove(pedidoDeletar);
            contexto.SaveChanges();
        }

        public List<Pedido> Listar()
        {
            return contexto.Pedidos.ToList();
        }

        public Pedido ObterPorId(int id)
        {
            return contexto.Pedidos.FirstOrDefault(p => p.Id == id);
        }
    }
}
