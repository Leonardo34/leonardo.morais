using Demo1.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demo1.Infraestrutura.Repositorios
{
    public class PedidoRepositorio : IPedidoRepositorio
    {
        private static string CONEXAO_STRING = "Server=13.65.101.67; Database=aluno04db; User id=leonardo.morais; Password=123456";

        public void Alterar(Pedido pedido)
        {
            throw new NotImplementedException();
        }

        public void Criar(Pedido pedido)
        {
            using (var conexaoDb = new SqlConnection(CONEXAO_STRING))
            {
                conexaoDb.Open();
                using (var command = conexaoDb.CreateCommand())
                {
                    command.CommandText =
                        @"INSERT INTO Produto (NomeCliente) VALUES (@nome)";
                    command.Parameters.AddWithValue("nome", pedido.NomeCliente);
                    command.ExecuteNonQuery();
                    command.Parameters.Clear();

                    foreach (var item in pedido.Itens)
                    {
                        command.CommandText = @"INSERT INTO ItemPedido (PedidoId, ProdutoId, Quantidade) 
                            VALUES(@pedidoId, @produtoId, @quantidade)";
                        command.Parameters.AddWithValue("pedidoId", item.Id);
                        command.Parameters.AddWithValue("produtoId", item.ProdutoId);
                        command.Parameters.AddWithValue("quantidade", item.Quantidade);
                        command.ExecuteNonQuery();
                        command.Parameters.Clear();

                        command.CommandText = @"UPDATE Produto SET Estoque = 
                            Estoque -  @quantidade WHERE Id = @itemProdutoId";
                        command.Parameters.AddWithValue("quantidade", item.Quantidade);
                        command.Parameters.AddWithValue("itemProdutoId", item.ProdutoId);
                        command.Parameters.Clear();
                    }
                }
                using (var command = conexaoDb.CreateCommand())
                {
                    command.CommandText = "SELECT @@IDENTITY";
                    pedido.Id = (int)(decimal)command.ExecuteScalar();
                }
            }
        }

        public void Excluir(int id)
        {
            throw new NotImplementedException();
        }

        public IEnumerable<Pedido> Listar()
        {
            throw new NotImplementedException();
        }

        public Pedido Obter(int id)
        {
            throw new NotImplementedException();
        }
    }
}
