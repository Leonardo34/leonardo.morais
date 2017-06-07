using ImobiliariaCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ImobiliariaCrescer.Infraestrutura.Mappings
{
    public class PedidoAdicionalMap : EntityTypeConfiguration<PedidoAdicional>
    {
        public PedidoAdicionalMap()
        {
            ToTable("PedidosAdicionais");

            HasRequired(x => x.Adicional)
                .WithMany()
                .Map(x => x.MapKey("IdAdicional"));

            HasRequired(x => x.Pedido)
                .WithMany()
                .Map(x => x.MapKey("IdPedido"));
        }
    }
}
