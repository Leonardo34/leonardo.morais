using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demo1
{
    class CalculoIMC
    {
        public static double calcularIMC(double altura, double peso)
        {
            return peso / (altura * altura);
        }

        public static void Run()
        {
            Console.WriteLine("Digite a altura");
            var altura = double.Parse(Console.ReadLine());
            Console.WriteLine("Digite o peso");
            var peso = double.Parse(Console.ReadLine());
            System.Console.WriteLine(calcularIMC(altura, peso));
            Console.ReadKey();
        }
    }
}
