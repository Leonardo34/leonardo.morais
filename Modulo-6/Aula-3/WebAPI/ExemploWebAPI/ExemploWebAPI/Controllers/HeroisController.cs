using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using ExemploWebAPI.Models;

namespace ExemploWebAPI.Controllers
{
    public class HeroisController : ApiController
    {
        private static List<Heroi> Herois = new List<Heroi>();
        private static int IdGenerator = 0;
        private readonly object objetoLock = new object();

        public List<Heroi> GetHerois(int? id = null)
        {
            return id == null ? Herois : Herois.Where(h => h.Id == id).ToList();    
        }

        public IHttpActionResult Post(Heroi heroi)
        {
            if (heroi == null)
            {
                return BadRequest();
            }
            lock (objetoLock)
            {
                heroi.Id = IdGenerator++;
                Herois.Add(heroi);
            }
            return Ok();
        }
    }
}
