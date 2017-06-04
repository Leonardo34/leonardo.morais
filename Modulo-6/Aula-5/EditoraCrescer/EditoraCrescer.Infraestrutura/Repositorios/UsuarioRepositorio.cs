using EditoraCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraestrutura.Repositorios
{
    public class UsuarioRepositorio
    {
        private Contexto.Contexto contexto = new Contexto.Contexto();

        public void Salvar(Usuario usuario)
        {
            usuario.Permissoes.Add(BuscarPermissao(1));
            contexto.Usuarios.Add(usuario);
            contexto.SaveChanges();
        }

        public Permissao BuscarPermissao(int id)
        {
            return contexto.Permissoes.FirstOrDefault(p => p.Id == id);
        }

        public void Alterar(Usuario usuario)
        {
            contexto.Entry(usuario).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();
        }

        public Usuario Obter(string email)
        {
            return contexto.Usuarios
                .Include("Permissoes")
                .FirstOrDefault(u => u.Email.Equals(email));
        }
    }
}
