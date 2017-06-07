using ImobiliariaCrescer.Infraestrutura.ContextoEntity;
using ImobiliariaCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ImobiliariaCrescer.Infraestrutura.Repositorios
{
    public class ClienteRepositorio : IRepositorio<Cliente>
    {
        private Contexto contexto = new Contexto();

        public void Alterar(Cliente objeto)
        {
            contexto.Entry(objeto).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();
        }

        public void Criar(Cliente objeto)
        {
            contexto.Clientes.Add(objeto);
            contexto.SaveChanges();
        }

        public void Deletar(int id)
        {
            var clienteDeletado = ObterPorId(id);
            contexto.Clientes.Remove(clienteDeletado);
            contexto.SaveChanges();
        }

        public List<Cliente> Listar()
        {
            return contexto.Clientes.ToList();
        }

        public Cliente ObterPorId(int id)
        {
            return contexto.Clientes
                .FirstOrDefault(c => c.Id == id);
        }

        public Cliente ObterPorCpf(string cpf)
        {
            return contexto.Clientes
                .FirstOrDefault(c => c.Cpf == cpf);
        }
    }
}
