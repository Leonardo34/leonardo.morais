using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using ChatAPI.Models;

namespace ChatAPI.Controllers
{
    public class MensagensController : ApiController
    {
        private static List<Mensagem> Mensagens = new List<Mensagem>();
        private static int IdGenerator = 0;
        private readonly object objetoLock = new object();

        public List<Mensagem> GetMensagens()
        {
            return Mensagens;
        }

        public IHttpActionResult PostMensagem(Mensagem mensagem)
        {
            if (mensagem == null)
            {
                return BadRequest();
            }
            lock (objetoLock)
            {
                mensagem.Id = ++IdGenerator;
                Mensagens.Add(mensagem);
            }
            return Ok();
        }
    }
}
