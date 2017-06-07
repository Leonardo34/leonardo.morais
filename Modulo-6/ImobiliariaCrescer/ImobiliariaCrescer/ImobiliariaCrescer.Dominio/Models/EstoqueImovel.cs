using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ImobiliariaCrescer.Infraestrutura.Entidades
{
    public class EstoqueImovel
    {
        public int Id { get; set; }
        public Imovel Imovel { get; set; }
        public Combo Combo { get; set; }
        public int Quantidade { get; set; }
    }
}
