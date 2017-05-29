using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Demo1.Dominio.Entidades
{
    public class Produto
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public decimal Preco { get; set; }
        public int Estoque { get; set; }

        public bool validar(out List<string> mensagens)
        {
            mensagens = new List<string>();
            if (Estoque < 1)
            {
                mensagens.Add("O estoque deve ser maior que 0");
            }
            if (Preco < 1)
            {
                mensagens.Add("Preço deve ser maior que ou igual a 1");
            }
            if (Nome == null || Nome.Length < 1)
            {
                mensagens.Add("O nome do produto deve ser informado");
            }
            return mensagens.Count == 0;
        }
    }
}