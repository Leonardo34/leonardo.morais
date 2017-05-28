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
        private static int IdMensagemGenerator = 0;

        [HttpPost]
        public IHttpActionResult Post(int id, [FromBody] Mensagem mensagem)
        {
            var chat = BatePapoById(id);
            if (chat == null)
            {
                return BadRequest();
            }
            mensagem.Id = ++IdMensagemGenerator;
            mensagem.DataEnvio = DateTime.Now;
            chat.AdicionarMensagem(mensagem);
            return Ok();
        }

        [HttpGet]
        public List<Chat> GetBatePapos(int? id = null)
        {
            return id == null ? SalasBatePapo :
                SalasBatePapo.Where(s => s.Id == id).ToList();
        }

        private Chat BatePapoById(int id)
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
