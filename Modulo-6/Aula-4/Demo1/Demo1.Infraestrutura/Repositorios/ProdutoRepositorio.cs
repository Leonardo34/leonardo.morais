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

        public List<Produto> Listar()
        {
            var produtos = new List<Produto>();
            using (var conexaoDb = new SqlConnection(CONEXAO_STRING))
            {
                conexaoDb.Open();
                using (var command = conexaoDb.CreateCommand())
                {
                    command.CommandText =
                        @"Select Id, Nome, Preco, Estoque from Produto;";
                    

                    var dataReader = command.ExecuteReader();
                    while (dataReader.Read())
                    {
                        produtos.Add(new Produto()
                        {
                            Id = (int)dataReader["Id"],
                            Preco = (decimal)dataReader["Preco"],
                            Nome = (string)dataReader["Nome"],
                            Estoque = (int)dataReader["Estoque"]
                        });
                    }
                }
            }
            return produtos;
        }

        public void Alterar(Produto produto)
        {
            using (var conexaoDb = new SqlConnection(CONEXAO_STRING))
            {
                conexaoDb.Open();
                using (var command = conexaoDb.CreateCommand())
                {
                    command.CommandText =
                        "UPDATE PRODUTO SET Nome = @nome, Preco = @preco, Estoque = @estoque WHERE Id = @id";
                    command.Parameters.AddWithValue("nome", produto.Nome);
                    command.Parameters.AddWithValue("preco", produto.Preco);
                    command.Parameters.AddWithValue("estoque", produto.Estoque);
                    command.Parameters.AddWithValue("id", produto.Id);

                    command.ExecuteNonQuery();
                }
            }
        }

        public void Excluir(int id)
        {
            using (var conexaoDb = new SqlConnection(CONEXAO_STRING))
            {
                conexaoDb.Open();
                using (var command = conexaoDb.CreateCommand())
                {
                    command.CommandText = "DELETE Produto WHERE Id = @id";
                    command.Parameters.AddWithValue("id", id);
                    command.ExecuteNonQuery();
                }
            }
        }

        public Produto Obter(int id)
        {
            Produto produto = null;
            using (var conexaoDb = new SqlConnection(CONEXAO_STRING))
            {
                conexaoDb.Open();
                using (var comando = conexaoDb.CreateCommand())
                {
                    comando.CommandText =
                        "SELECT Id, Nome, Preco, Estoque FROM Produto WHERE Id = @id";
                    comando.Parameters.AddWithValue("@id", id);

                    var dataReader = comando.ExecuteReader();
                    while (dataReader.Read())
                    {
                        produto = new Produto();
                        produto.Id = (int)dataReader["Id"];
                        produto.Nome = (string)dataReader["Nome"];
                        produto.Preco = (decimal)dataReader["Preco"];
                        produto.Estoque = (int)dataReader["Estoque"];
                        return produto;
                    }
                }
            }
            return produto;
        }
    }
}
