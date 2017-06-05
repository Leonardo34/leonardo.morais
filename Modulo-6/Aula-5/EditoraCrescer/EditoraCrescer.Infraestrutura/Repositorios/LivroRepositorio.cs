using EditoraCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using EditoraCrescer.Infraestrutura.Contexto;
using System.Linq.Expressions;
using System.Data.Entity;

namespace EditoraCrescer.Infraestrutura.Repositorios
{
    public class LivroRepositorio
    {
        private Contexto.Contexto contexto = new Contexto.Contexto();

        public List<Livro> ListarTodosLivros()
        {
            return contexto.Livros
                .Include("Autor")
                .Include("Revisor")
                .ToList();
        }

        public dynamic Listar(int skip, int take)
        {
            DateTime seteDiasAtras = DateTime.Now.AddDays(-7);

            return contexto.Livros
                .Where(l => l.DataPublicacao != null &&
                    DbFunctions.TruncateTime(l.DataPublicacao.Value) < seteDiasAtras)
                .OrderByDescending(l => l.DataPublicacao)
                .Skip(skip)
                .Take(take)
                .Select(camposBasicos)
                .ToList();
        }

        public dynamic ListarLancamentos()
        {
            DateTime seteDiasAtras = DateTime.Now.AddDays(-7);

            return contexto.Livros
                .Where(l => l.DataPublicacao != null &&
                    l.DataPublicacao > seteDiasAtras)
                .OrderByDescending(l => l.DataPublicacao)
                .Select(camposBasicos)
                .ToList();
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
            return contexto.Livros
                .Include("Autor")
                .Include("Revisor")
                .FirstOrDefault(l => l.Isbn == isbn);
        }

        public List<Livro> ObterPorGenero(string genero)
        {
            return contexto.Livros
                .Where(l => l.Genero.Contains(genero))
                .ToList();
        }

        public void Alterar(Livro livro)
        {
            contexto.Entry(livro).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();
        }

        public void Publicar(int isbn)
        {
            var livro = ObterPorIsbn(isbn);
            if (livro != null)
            {
                livro.DataPublicacao = DateTime.Now;
                Alterar(livro);
            }
        }

        private Expression<Func<Livro, dynamic>> camposBasicos =
            (l => new
            {
                Isbn = l.Isbn,
                Titulo = l.Titulo,
                Capa = l.Capa,
                NomeAutor = l.Autor.Nome,
                Genero = l.Genero
            });
    }
}
