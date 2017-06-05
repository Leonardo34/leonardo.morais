using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ImobiliariaCrescer.Infraestrutura.Entidades
{
    public class Combo
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public decimal Preco { get; set; }
        public int Quartos { get; set; }
        public int Banheiros { get; set; }
        public int Cozinhas { get; set; }
        public int Salas { get; set; }
    }
}
