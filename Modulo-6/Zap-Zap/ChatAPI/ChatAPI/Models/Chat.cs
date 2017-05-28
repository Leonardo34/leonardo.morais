using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ChatAPI.Models
{
    public class Chat
    {
        public int Id { get; set; }
        public string NomeChat { get; set; }
        public List<Usuario> Usuarios { get; set; }
        public List<Mensagem> Mensagens { get; set; }
    }
}