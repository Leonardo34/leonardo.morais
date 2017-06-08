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
            ToTable("Pedidos2");

            HasRequired(x => x.Cliente)
                .WithMany()
                .Map(x => x.MapKey("IdCliente"));

            HasRequired(x => x.Imovel)
                .WithMany()
                .Map(x => x.MapKey("IdImovel"));

            HasRequired(x => x.Combo)
                .WithMany()
                .Map(x => x.MapKey("IdCombo"));

            HasMany(x => x.Adicionais).WithMany()
                .Map(x =>
                {
                    x.MapLeftKey("IdPedido");
                    x.MapRightKey("IdAdicional");
                    x.ToTable("PedidoAdicional2");
                });
        }
    }
}
