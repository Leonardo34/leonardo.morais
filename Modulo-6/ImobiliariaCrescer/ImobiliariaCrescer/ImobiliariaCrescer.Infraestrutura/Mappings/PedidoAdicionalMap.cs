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
                .HasForeignKey(x => x.IdAdicional);

            HasRequired(x => x.Pedido)
                .WithMany()
                .HasForeignKey(x => x.IdPedido);
        }
    }
}
