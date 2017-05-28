using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ChatAPI.Models
{
    public class Mensagem
    {
        public int Id { get; set; }
        public string NomeAutor { get; set; }
        public string UrlFotoAutor { get; set; }
        public string Conteudo { get; set; }
    }
}