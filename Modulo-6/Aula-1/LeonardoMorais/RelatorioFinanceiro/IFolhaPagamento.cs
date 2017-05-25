using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RelatorioFinanceiro
{
    interface IFolhaPagamento
    {
        Demonstrativo gerarDemonstrativo(int horasCategoria, double salarioBase,
            double horasExtras, double horasDescontadas);
    }
}
