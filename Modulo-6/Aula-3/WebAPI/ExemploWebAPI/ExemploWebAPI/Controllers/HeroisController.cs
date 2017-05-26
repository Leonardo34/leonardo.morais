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
        public List<Heroi> GetHerois()
        {
            List<Heroi> herois = new List<Heroi>() {
                new Heroi()
                {
                    Id = 1,
                    Nome = "Goku",
                    Poder = new Poder()
                    {
                        Nome = "Kamehameha",
                        Dano = 20
                    }
                },
                new Heroi()
                {
                    Id = 2,
                    Nome = "Naruto",
                    Poder = new Poder()
                    {
                        Nome = "Rasengan",
                        Dano = 200
                    }
                }
            };
            return herois;    
        }

        public IEnumerable<Heroi> GetHeroiById(int id)
        {
            List<Heroi> herois = new List<Heroi>() {
                new Heroi()
                {
                    Id = 1,
                    Nome = "Goku",
                    Poder = new Poder()
                    {
                        Nome = "Kamehameha",
                        Dano = 20
                    }
                },
                new Heroi()
                {
                    Id = 2,
                    Nome = "Naruto",
                    Poder = new Poder()
                    {
                        Nome = "Rasengan",
                        Dano = 200
                    }
                }
            };
            return herois.Where(h => h.Id == id);
        }
    }
}
