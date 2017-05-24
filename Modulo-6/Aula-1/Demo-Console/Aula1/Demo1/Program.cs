using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demo1
{
    class Program
    {
        public static void Run(string[] args)
        {
            var pessoa = new Pessoa(0, "Leonardo");
            System.Console.WriteLine(pessoa.ToString());
            Console.ReadKey();
        }
    }
}
