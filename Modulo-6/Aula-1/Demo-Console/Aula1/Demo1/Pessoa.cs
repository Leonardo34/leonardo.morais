using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demo1
{
    class Pessoa
    {
        private String Nome { get; set; }
        private int Id { get; set; }

        public Pessoa(int Id, String Nome)
        {
            this.Id = Id;
            this.Nome = Nome;
        }

        public override String ToString()
        {
            return "Nome: " + Nome + " ID: " + Id;
        }
    }
}
