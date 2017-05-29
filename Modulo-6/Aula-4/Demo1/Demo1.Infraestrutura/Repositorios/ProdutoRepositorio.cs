using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.SqlClient;
using Demo1.Dominio.Entidades;

namespace Demo1.Infraestrutura.Repositorios
{
    public class ProdutoRepositorio
    {
        private static string CONEXAO_STRING = "Server=13.65.101.67; Database=aluno04db; User id=leonardo.morais; Password=123456";

        public void Criar(Produto produto)
        {
            using (var conexaoDb = new SqlConnection(CONEXAO_STRING))
            {
                conexaoDb.Open();
                using (var command = conexaoDb.CreateCommand())
                {
                    command.CommandText =
                        @"INSERT INTO Produto (Nome, Preco, Estoque)
                        VALUES (@nome, @preco, @estoque)";
                    command.Parameters.AddWithValue("nome", produto.Nome);
                    command.Parameters.AddWithValue("preco", produto.Preco);
                    command.Parameters.AddWithValue("estoque", produto.Estoque);

                    command.ExecuteNonQuery();
                }
                using (var command = conexaoDb.CreateCommand())
                {
                    command.CommandText = "SELECT @@IDENTITY";
                    produto.Id = (int)(decimal)command.ExecuteScalar();
                }
            }
        }
    }
}
