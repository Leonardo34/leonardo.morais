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
            contexto.Entry(objeto.Combo).State = System.Data.Entity.EntityState.Unchanged;
            contexto.Entry(objeto.Imovel).State = System.Data.Entity.EntityState.Unchanged;
            contexto.Entry(objeto.Cliente).State = System.Data.Entity.EntityState.Unchanged;
            foreach (var adicional in objeto.Adicionais)
            {
                contexto.Entry(adicional.Adicional).State = System.Data.Entity.EntityState.Unchanged;
            }
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
            return contexto.Pedidos
                .Include("Combo")
                .Include("Imovel")
                .Include("Cliente")
                .Include("Adicionais")
                .ToList();
        }

        public Pedido ObterPorId(int id)
        {
            return contexto.Pedidos.FirstOrDefault(p => p.Id == id);
        }
    }
}
