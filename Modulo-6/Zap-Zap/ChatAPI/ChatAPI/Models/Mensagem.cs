using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ChatAPI.Models
{
    public class Mensagem
    {
        public int Id { get; set; }
        public string Conteudo { get; set; }
        public Usuario Autor { get; set; }
        public DateTime DataEnvio { get; set; }
    }
}