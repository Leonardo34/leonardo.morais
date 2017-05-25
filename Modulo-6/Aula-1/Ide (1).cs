using System;
namespace Teste
{
public interface IFolhaPagamento
{
    Demonstrativo gerarDemonstrativo(int horasCategoria, double salarioBase,
            double horasExtras, double horasDescontadas);
}

public class HorasCalculadas
{
    public static void Main()
    {
        var empregado = new Empregado(200, 5000, 50, 10);
        Console.WriteLine("Testets");
        Console.WriteLine(empregado.CalcularSalarioLiquido());
    }
    
    public HorasCalculadas(double qtdHoras, double valorTotalHoras)
    {
        QtdHoras = qtdHoras;
        ValorTotalHoras = valorTotalHoras;
    }
    public double QtdHoras { get; private set; }
    public double ValorTotalHoras { get; private set; }
}
    
public class Desconto
{
    public Desconto(double aliquota, double valor)
    {
        Aliquota = aliquota;
        Valor = valor;
    }

    public double Aliquota { get; private set; }
    public double Valor { get; private set; }
}

public class Demonstrativo
{
    public Demonstrativo(
        double salarioBase,
        double hrsConvencao,
        HorasCalculadas horasExtras,
        HorasCalculadas horasDescontadas,
        double totalProventos,
        Desconto inss,
        Desconto irrf,
        double totalDescontos,
        double totalLiquido,
        Desconto fgts)
    {
        SalarioBase = salarioBase;
        HrsConvencao = hrsConvencao;
        HorasExtras = horasExtras;
        HorasDescontadas = horasDescontadas;
        TotalProventos = totalProventos;
        Inss = inss;
        Irrf = irrf;
        TotalDescontos = totalDescontos;
        TotalLiquido = totalLiquido;
        Fgts = fgts;
    }

    public double SalarioBase { get; private set; }
    public double HrsConvencao { get; private set; }
    public HorasCalculadas HorasExtras { get; private set; }
    public HorasCalculadas HorasDescontadas { get; private set; }
    public double TotalProventos { get; private set; }
    public Desconto Inss { get; private set; }
    public Desconto Irrf { get; private set; }
    public double TotalDescontos { get; private set; }
    public double TotalLiquido { get; private set; }
    public Desconto Fgts { get; private set; }
}

public class FolhaPagamento : IFolhaPagamento
{
    public Demonstrativo gerarDemonstrativo(int horasCategoria, double salarioBase,
            double horasExtras, double horasDescontadas)
    {
        Empregado empregado = new Empregado(horasCategoria, salarioBase, horasExtras, horasDescontadas);
        return null;
    }
}

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
        return new HorasCalculadas(HorasExtras, HorasExtras * SalarioHora);
    }
    
    public HorasCalculadas CalcularHorasDescontadas()
    {
        return new HorasCalculadas(HorasDescontadas, HorasDescontadas * SalarioHora);
    }
    
    public double CalcularTotalProventos()
    {
        var valorHorasExtras = CalcularHorasExtras().ValorTotalHoras;
        var valorHorasDescontadas = CalcularHorasDescontadas().ValorTotalHoras;
        return SalarioBase + valorHorasExtras - valorHorasDescontadas;
    }
    
    public Desconto CalcularINSS()
    {
        var totalProventos = CalcularTotalProventos();
        if (totalProventos < 1000) 
        {
            return new Desconto(0.08, totalProventos * 0.08);
        }
        if (totalProventos < 1500)
        {
            return new Desconto(0.09, totalProventos * 0.09);
        }
        return new Desconto(0.1, totalProventos * 0.1);
    }
    
    public Desconto CalcularIRRF()
    {
        var totalProventos = CalcularTotalProventos() - CalcularINSS().Valor;
        if (totalProventos < 1710.78)
        {
            return new Desconto(0, 0);
        }
        if (totalProventos < 2563.91)
        {
            return new Desconto(0.075, totalProventos * 0.075);
        }
        if (totalProventos < 3418.59)
        {
            return new Desconto(0.15, totalProventos * 0.15);
        }
        if (totalProventos < 4271.59)
        {
            return new Desconto(0.225, totalProventos * 0.225);
        }
        return new Desconto(0.275, totalProventos * 0.275);
    }
    
    public double CalcularTotalDescontos()
    {
        return CalcularINSS().Valor + CalcularIRRF().Valor;
    }
    
    public double CalcularSalarioLiquido()
    {
        return CalcularTotalProventos() - CalcularTotalDescontos();
    }
    
    public Desconto CalcularFGTS()
    {
        return new Desconto(0.11, CalcularTotalProventos() * 0.11);
    }
}
}
