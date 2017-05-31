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
        private Contexto.Contexto livroContexto = new Contexto.Contexto();

        public LivroRepositorio()
        { }

        public List<Livro> Listar()
        {
            return livroContexto.Livros.ToList();
        }

        public void Salvar(Livro livro)
        {
            livroContexto.Livros.Add(livro);
            livroContexto.SaveChanges();
        }

        public Livro Excluir(int id)
        {
            var livroRemovido = livroContexto.Livros.FirstOrDefault(l => l.Isbn == id);
            livroContexto.Livros.Remove(livroRemovido);
            livroContexto.SaveChanges();
            return livroRemovido;
        }
    }
}
