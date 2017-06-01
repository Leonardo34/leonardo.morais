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
        private Contexto.Contexto contexto = new Contexto.Contexto();

        public List<Autor> Listar()
        {
            return contexto.Autores.ToList();
        }

        public void Salvar(Autor autor)
        {
            contexto.Autores.Add(autor);
            contexto.SaveChanges();
        }

        public Autor Excluir(int id)
        {
            var autorExcluido = contexto.Autores.FirstOrDefault(a => a.Id == id);
            contexto.Autores.Remove(autorExcluido);
            contexto.SaveChanges();
            return autorExcluido;
        }

        public Autor Obter(int id)
        {
            return contexto.Autores.FirstOrDefault(a => a.Id == id);
        }

        public List<Livro> ObterLivrosAutor(int idAutor)
        {
            return contexto.Livros.Where(l => l.IdAutor == idAutor).ToList();
        }


    }
}
