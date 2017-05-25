using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demonstrativo.Folha
{
    public class Empregado
    {

        public Empregado(int horasCategoria, double salarioBase, double horasExtras, double horasDescontadas)
        {
            HorasCategoria = horasCategoria;
            SalarioBase = salarioBase;
            HorasExtras = horasExtras;
            HorasDescontadas = horasDescontadas;
            SalarioHora = SalarioBase / HorasCategoria;
        }

        public int HorasCategoria { get; private set; }
        public double SalarioBase { get; private set; }
        public double HorasExtras { get; private set; }
        public double HorasDescontadas { get; private set; }
        public double SalarioHora { get; private set; }

        public HorasCalculadas CalcularHorasExtras()
        {
            return new HorasCalculadas(HorasExtras, Arredondar(HorasExtras * SalarioHora));
        }

        public HorasCalculadas CalcularHorasDescontadas()
        {
            return new HorasCalculadas(HorasDescontadas, Arredondar(HorasDescontadas * SalarioHora));
        }

        public double CalcularTotalProventos()
        {
            var valorHorasExtras = CalcularHorasExtras().ValorTotalHoras;
            var valorHorasDescontadas = CalcularHorasDescontadas().ValorTotalHoras;
            return Arredondar(SalarioBase + valorHorasExtras - valorHorasDescontadas);
        }

        public Desconto CalcularINSS()
        {
            var totalProventos = CalcularTotalProventos();
            if (totalProventos <= 1000)
            {
                return new Desconto(0.08, Arredondar(totalProventos * 0.08));
            }
            if (totalProventos <= 1500)
            {
                return new Desconto(0.09, Arredondar(totalProventos * 0.09));
            }
            return new Desconto(0.1, Arredondar(totalProventos * 0.1));
        }

        public Desconto CalcularIRRF()
        {
            var totalProventos = CalcularTotalProventos() - CalcularINSS().Valor;
            if (totalProventos <= 1710.78)
            {
                return new Desconto(0, 0);
            }
            if (totalProventos <= 2563.91)
            {
                return new Desconto(0.075, Arredondar(totalProventos * 0.075));
            }
            if (totalProventos <= 3418.59)
            {
                return new Desconto(0.15, Arredondar(totalProventos * 0.15));
            }
            if (totalProventos <= 4271.59)
            {
                return new Desconto(0.225, Arredondar(totalProventos * 0.225));
            }
            return new Desconto(0.275, Arredondar(totalProventos * 0.275));
        }

        public double CalcularTotalDescontos()
        {
            return Arredondar(CalcularINSS().Valor + CalcularIRRF().Valor);
        }

        public double CalcularSalarioLiquido()
        {
            return Arredondar(CalcularTotalProventos() - CalcularTotalDescontos());
        }

        public Desconto CalcularFGTS()
        {
            return new Desconto(0.11, Arredondar(CalcularTotalProventos() * 0.11));
        }

        public double Arredondar(double valor)
        {
            return Math.Truncate(valor * 100) / 100;
        }
    }      
}
