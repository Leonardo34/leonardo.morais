using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ImobiliariaCrescer.Infraestrutura.Entidades
{
    public class Pedido
    {
        public int Id { get; set; }
        public int IdCliente { get; set; }
        public Cliente Cliente { get; set; }
        public DateTime DataVenda { get; set; }
        public DateTime DataEntregaPrevista { get; set; }
        public DateTime? DataEntregaRealizada { get; set; }
        public int IdImovel { get; set; }
        public Imovel Imovel { get; set; }
        public int IdCombo { get; set; }
        public Combo Combo { get; set; }
        public List<PedidoAdicional> Adicionais { get; set; }
        public decimal? TotalPrevisto { get; set; }
        public decimal? TotalPago { get; set; }
    }
}
