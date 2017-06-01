using EditoraCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraestrutura.Repositorios
{
    public class RevisorRepositorio
    {
        private Contexto.Contexto contexto = new Contexto.Contexto();

        public List<Revisor> Listar()
        {
            return contexto.Revisores.ToList();
        }

        public void Salvar(Revisor revisor)
        {
            contexto.Revisores.Add(revisor);
            contexto.SaveChanges();
        }

        public Revisor Excluir(int id)
        {
            var revisorExcluido = contexto.Revisores.FirstOrDefault(r => r.Id == id);
            contexto.Revisores.Remove(revisorExcluido);
            contexto.SaveChanges();
            return revisorExcluido;
        }

        public Revisor Obter(int id)
        {
            return contexto.Revisores.FirstOrDefault(r => r.Id == id);
        }
    }
}
