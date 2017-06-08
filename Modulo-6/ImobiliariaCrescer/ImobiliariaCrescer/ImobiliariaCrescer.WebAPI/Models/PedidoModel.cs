using ImobiliariaCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ImobiliariaCrescer.WebAPI.Models
{
    public class PedidoModel
    {
        public List<Adicional> Adicionais { get; set; }
        public Combo Combo { get; set; }
        public Imovel Imovel { get; set; }
        public Cliente Cliente { get; set; }
        public int DiasAluguel { get; set; }
    }
}