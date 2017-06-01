using EditoraCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using EditoraCrescer.Infraestrutura.Contexto;

namespace EditoraCrescer.Infraestrutura.Repositorios
{
    public class LivroRepositorio
    {
        private Contexto.Contexto contexto = new Contexto.Contexto();

        public LivroRepositorio()
        { }

        public List<Livro> Listar()
        {
            return contexto.Livros.ToList();
        }

        public void Salvar(Livro livro)
        {
            contexto.Livros.Add(livro);
            contexto.SaveChanges();
        }

        public Livro Excluir(int id)
        {
            var livroRemovido = contexto.Livros.FirstOrDefault(l => l.Isbn == id);
            contexto.Livros.Remove(livroRemovido);
            contexto.SaveChanges();
            return livroRemovido;
        }

        public Livro ObterPorIsbn(int isbn)
        {
            return contexto.Livros.FirstOrDefault(l => l.Isbn == isbn);
        }

        public List<Livro> ObterPorGenero(string genero)
        {
            return contexto.Livros
                .Where(l => l.Genero.Contains(genero))
                .ToList();
        }
    }
}
