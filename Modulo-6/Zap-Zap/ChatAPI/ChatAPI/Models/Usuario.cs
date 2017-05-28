using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ChatAPI.Models
{
    public class Usuario
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public string UrlImagemPerfil { get; set; }

        public override bool Equals(object obj)
        {
            Usuario other = (Usuario)obj;
            return Id == other.Id;
        }
    }
}