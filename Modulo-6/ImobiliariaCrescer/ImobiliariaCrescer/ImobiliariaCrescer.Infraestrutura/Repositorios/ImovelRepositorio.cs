using ImobiliariaCrescer.Infraestrutura.ContextoEntity;
using ImobiliariaCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ImobiliariaCrescer.Infraestrutura.Repositorios
{
    public class ImovelRepositorio : IRepositorio<Imovel>
    {
        private Contexto contexto = new Contexto();

        public void Alterar(Imovel objeto)
        {
            contexto.Entry(objeto).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();
        }

        public void Criar(Imovel objeto)
        {
            contexto.Imoveis.Add(objeto);
            contexto.SaveChanges();
        }

        public void Deletar(int id)
        {
            var imovelDeletado = ObterPorId(id);
            contexto.Imoveis.Remove(imovelDeletado);
            contexto.SaveChanges();
        }

        public List<Imovel> Listar()
        {
            return contexto.Imoveis.ToList();
        }

        public Imovel ObterPorId(int id)
        {
            return contexto.Imoveis
                .FirstOrDefault(i => i.Id == id);
        }
    }
}
