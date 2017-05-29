using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using ChatAPI.Models;
using System.Text.RegularExpressions;

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
            mensagem.Conteudo =
                Regex.Replace(mensagem.Conteudo, "andre nunes", "$$$$$ $$$$$", RegexOptions.IgnoreCase);
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
                    Descricao = "O bate-papo mais sapeca do brasil",
                    UrlImagemChat = "http://img.ibxk.com.br/ns/rexposta/2016/05/28/28103856145020.jpg?watermark=neaki&watermark=neaki",
                    DataCriacao = DateTime.Now,
                    Mensagens = new List<Mensagem>()
                },
                new Chat()
                {
                    Id = 2,
                    NomeChat = "Memes",
                    Descricao = "Só memes",
                    UrlImagemChat = "http://www.whatstube.com.br/wp-content/uploads/2015/10/sexta-feira-curticao.jpg", 
                    DataCriacao = DateTime.Now,
                    Mensagens = new List<Mensagem>()
                },
                new Chat()
                {
                    Id = 3,
                    NomeChat = "Futebol",
                    Descricao = "Só os boleiros",
                    UrlImagemChat = "http://www.maisfutebol.iol.pt/multimedia/oratvi/multimedia/imagem/id/58514dde0cf29541c419bfe2/600.58514dde0cf29541c419bfe2.jpg",
                    DataCriacao = DateTime.Now,
                    Mensagens = new List<Mensagem>()
                },
                new Chat()
                {
                    Id = 4,
                    NomeChat = "Política",
                    Descricao = "FORA TEMER",
                    UrlImagemChat = "http://www.minhaserie.com.br//images/highlights/000/009/108/744.jpg",
                    DataCriacao = DateTime.Now,
                    Mensagens = new List<Mensagem>()
                },
                new Chat()
                {
                    Id = 5,
                    NomeChat = "Series",
                    Descricao = "Só pra quem assiste Eu a Patroa e as Crianças",
                    UrlImagemChat = "http://pequenaverissimo.com/wp-content/uploads/2015/07/00-curi.jpg",
                    DataCriacao = DateTime.Now,
                    Mensagens = new List<Mensagem>()
                }
            };
        }
    }
}
