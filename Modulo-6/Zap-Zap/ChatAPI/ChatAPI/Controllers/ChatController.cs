using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using ChatAPI.Models;

namespace ChatAPI.Controllers
{
    public class ChatController : ApiController
    {
        private static List<Chat> SalasBatePapo = PopularBatePapo();
        private static List<Usuario> Usuarios = new List<Usuario>();
        private static int IdUsuarioGenerator = 0;
        private static int IdChatGenerator = 0;

        private static object ObjetoLock = new object();

        public IHttpActionResult Post(Mensagem mensagem)
        {
            return Ok();
        }

        public List<Chat> GetBatePapos(int? id = null)
        {
            if (id == null)
            {
                return SalasBatePapo;
            }
            return SalasBatePapo.Where(s => s.Id == id).ToList();
        }

        private static List<Chat> PopularBatePapo()
        {
            return new List<Chat>()
            {
                new Chat()
                {
                    Id = 1,
                    NomeChat = "Sapecagem",
                    Usuarios = new List<Usuario>(),
                    Mensagens = new List<Mensagem>()
                },
                new Chat()
                {
                    Id = 2,
                    NomeChat = "Memes",
                    Usuarios = new List<Usuario>(),
                    Mensagens = new List<Mensagem>()
                }
            };
        }
    }
}
