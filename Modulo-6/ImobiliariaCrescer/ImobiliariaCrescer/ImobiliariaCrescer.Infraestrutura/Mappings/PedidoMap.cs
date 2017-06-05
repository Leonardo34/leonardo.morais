using ImobiliariaCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ImobiliariaCrescer.Infraestrutura.Mappings
{
    public class PedidoMap : EntityTypeConfiguration<Pedido>
    {
        public PedidoMap()
        {
            ToTable("Pedidos");

            HasRequired(x => x.Cliente)
                .WithMany()
                .HasForeignKey(x => x.IdCliente);

            HasRequired(x => x.Imovel)
                .WithMany()
                .HasForeignKey(x => x.IdImovel);

            HasRequired(x => x.Combo)
                .WithMany()
                .HasForeignKey(x => x.IdCombo);

            HasMany(x => x.Adicionais).WithMany()
                .Map(x =>
                {
                    x.MapLeftKey("IdPedido");
                    x.MapRightKey("IdAdicional");
                    x.ToTable("PedidoAdicional");
                });
        }
    }
}
