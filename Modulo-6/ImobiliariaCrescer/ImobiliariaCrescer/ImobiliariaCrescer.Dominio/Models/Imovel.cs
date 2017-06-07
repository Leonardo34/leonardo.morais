using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ImobiliariaCrescer.Infraestrutura.Entidades
{
    public class Imovel
    {
        public int Id { get; set; }
        public string Tipo { get; set; } 
        public List<EstoqueImovel> Estoques { get; set; }
    }
}
