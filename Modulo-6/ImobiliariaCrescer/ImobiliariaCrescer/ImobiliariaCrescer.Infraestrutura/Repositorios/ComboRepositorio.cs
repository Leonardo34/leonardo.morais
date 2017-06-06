using ImobiliariaCrescer.Infraestrutura.ContextoEntity;
using ImobiliariaCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ImobiliariaCrescer.Infraestrutura.Repositorios
{
    public class ComboRepositorio : IRepositorio<Combo>
    {
        private Contexto contexto = new Contexto();

        public void Alterar(Combo objeto)
        {
            contexto.Entry(objeto).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();
        }

        public void Criar(Combo objeto)
        {
            contexto.Combos.Add(objeto);
            contexto.SaveChanges();
        }

        public void Deletar(int id)
        {
            var comboDeletado = ObterPorId(id);
            contexto.Combos.Remove(comboDeletado);
            contexto.SaveChanges();
        }

        public List<Combo> Listar()
        {
            return contexto.Combos.ToList();
        }

        public Combo ObterPorId(int id)
        {
            return contexto.Combos.FirstOrDefault(c => c.Id == id);
        }
    }
}
