using EditoraCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraestrutura.Repositorios
{
    public class AutorRepositorio
    {
        private Contexto.Contexto autorContexto = new Contexto.Contexto();

        public List<Autor> Listar()
        {
            return autorContexto.Autores.ToList();
        }

        public void Salvar(Autor autor)
        {
            autorContexto.Autores.Add(autor);
        }

        public Autor Excluir(int id)
        {
            var autorExcluido = autorContexto.Autores.FirstOrDefault(a => a.Id == id);
            autorContexto.Autores.Remove(autorExcluido);
            return autorExcluido;
        }
    }
}
