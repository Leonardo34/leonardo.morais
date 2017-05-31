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
        private Contexto.Contexto revisorContexto = new Contexto.Contexto();

        public List<Revisor> Listar()
        {
            return revisorContexto.Revisores.ToList();
        }

        public void Salvar(Revisor revisor)
        {
            revisorContexto.Revisores.Add(revisor);
        }

        public Revisor Excluir(int id)
        {
            var revisorExcluido = revisorContexto.Revisores.FirstOrDefault(r => r.Id == id);
            revisorContexto.Revisores.Remove(revisorExcluido);
            return revisorExcluido;
        }
    }
}
