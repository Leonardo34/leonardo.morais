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
        public Cliente Cliente { get; set; }
        public DateTime DataVenda { get; set; }
        public DateTime DataEntregaPrevista { get; set; }
        public DateTime? DataEntregaRealizada { get; set; }
        public Imovel Imovel { get; set; }
        public Combo Combo { get; set; }
        public List<PedidoAdicional> Adicionais { get; set; }
        public decimal? TotalPrevisto { get; set; }
        public decimal? TotalPago { get; set; }

        public void CalcularPrecoLocacao()
        {
            TotalPrevisto = 0;
            TimeSpan ts = DataEntregaPrevista - DataVenda;
            var diffDays = ts.Days;
            TotalPrevisto += Combo.PrecoPorDia * diffDays;
            foreach (var adicional in Adicionais)
            {
                TotalPrevisto += adicional.Adicional.PrecoPorDia * diffDays;
            }
        }

        public void CalcularPrecoTotal()
        {
            TotalPago = TotalPrevisto;
            TimeSpan ts = ((DateTime)DataEntregaRealizada) - DataEntregaPrevista;
            var diffDays = ts.Days;
            if (diffDays > 0)
            {
                TotalPago += Combo.PrecoPorDia * diffDays * 2;
                foreach (var adicional in Adicionais)
                {
                    TotalPago += adicional.Adicional.PrecoPorDia * diffDays * 2;
                }
            }
        }
    }
}
