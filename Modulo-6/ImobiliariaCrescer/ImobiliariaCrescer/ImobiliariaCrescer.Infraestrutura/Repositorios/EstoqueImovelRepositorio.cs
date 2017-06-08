using ImobiliariaCrescer.Infraestrutura.ContextoEntity;
using ImobiliariaCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ImobiliariaCrescer.Infraestrutura.Repositorios
{
    public class EstoqueImovelRepositorio : IRepositorio<EstoqueImovel>
    {
        private Contexto contexto = new Contexto();

        public void Alterar(EstoqueImovel objeto)
        {
            contexto.Entry(objeto).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();
        }

        public void RetirarImovelEstoque(int idImovel, int idCombo)
        {
            var estoque = contexto.Estoques
                .Where(e => e.Imovel.Id == idImovel && e.Combo.Id == idCombo)
                .FirstOrDefault();

            estoque.Quantidade -= 1;
            Alterar(estoque);
        }

        public void AdicionarImovelEstoque(int idImovel, int idCombo)
        {
            var estoque = contexto.Estoques
                .Where(e => e.Imovel.Id == idImovel && e.Combo.Id == idCombo)
                .FirstOrDefault();

            estoque.Quantidade += 1;
            Alterar(estoque);
        }

        public void Criar(EstoqueImovel objeto)
        {
            contexto.Entry(objeto.Combo).State = System.Data.Entity.EntityState.Unchanged;
            contexto.Entry(objeto.Imovel).State = System.Data.Entity.EntityState.Unchanged;
            contexto.Estoques.Add(objeto);
            contexto.SaveChanges();
        }

        public void Deletar(int id)
        {
            var estoqueDeletar = ObterPorId(id);
            contexto.Estoques.Remove(estoqueDeletar);
            contexto.SaveChanges();
        }

        public List<EstoqueImovel> Listar()
        {
            return contexto.Estoques.ToList();
        }

        public EstoqueImovel ObterPorId(int id)
        {
            return contexto.Estoques.FirstOrDefault(e => e.Id == id);
        }
    }
}
