using ImobiliariaCrescer.Infraestrutura.ContextoEntity;
using ImobiliariaCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ImobiliariaCrescer.Infraestrutura.Repositorios
{
    public class AdicionalRepositorio
    {
        private Contexto contexto = new Contexto();

        public void Alterar(Adicional objeto)
        {
            contexto.Entry(objeto).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();
        }

        public void Criar(Adicional objeto)
        {
            contexto.Adicionais.Add(objeto);
            contexto.SaveChanges();
        }

        public void Deletar(int id)
        {
            var adicionalDeletado = ObterPorId(id);
            contexto.Adicionais.Remove(adicionalDeletado);
            contexto.SaveChanges();
        }

        public List<Adicional> Listar()
        {
            return contexto.Adicionais
                .Where(a => a.Quantidade > 0)
                .ToList();
        }

        public Adicional ObterPorId(int id)
        {
            return contexto.Adicionais.FirstOrDefault(a => a.Id == id);
        }
    }
}
