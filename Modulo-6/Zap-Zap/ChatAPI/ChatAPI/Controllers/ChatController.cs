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

        private static object ObjetoLock = new object();

        [HttpPost]
        public IHttpActionResult Post(int id, [FromBody] Mensagem mensagem)
        {
            var chat = SalasBatePapo.FirstOrDefault(s => s.Id == id);
            if (chat == null)
            {
                return BadRequest();
            }
            chat.AdicionarMensagem(mensagem);
            return Ok();
        }

        [HttpGet]
        public List<Chat> Get()
        {
            return SalasBatePapo;
        }

        [HttpGet]
        private Chat Get(int id)
        {
            return SalasBatePapo.FirstOrDefault(s => s.Id == id);
        }

        private static List<Chat> PopularBatePapo()
        {
            return new List<Chat>()
            {
                new Chat()
                {
                    Id = 1,
                    NomeChat = "Sapecagem",
                    Mensagens = new List<Mensagem>()
                },
                new Chat()
                {
                    Id = 2,
                    NomeChat = "Memes",
                    Mensagens = new List<Mensagem>()
                }
            };
        }
    }
}
