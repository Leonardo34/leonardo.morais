using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RelatorioFinanceiro
{
    class FolhaPagamento : IFolhaPagamento
    {
        public Demonstrativo gerarDemonstrativo(int horasCategoria, double salarioBase,
                double horasExtras, double horasDescontadas)
        {
            Empregado empregado = new Empregado(horasCategoria, salarioBase, horasExtras, horasDescontadas);
            var demonstrativo = new Demonstrativo(
                empregado.SalarioBase, empregado.HorasCategoria, empregado.CalcularHorasExtras(),
                empregado.CalcularHorasDescontadas(), empregado.CalcularTotalProventos(),
                empregado.CalcularINSS(), empregado.CalcularIRRF(), empregado.CalcularTotalDescontos(),
                empregado.CalcularSalarioLiquido(), empregado.CalcularFGTS());
            return demonstrativo;
        }
    }
}
