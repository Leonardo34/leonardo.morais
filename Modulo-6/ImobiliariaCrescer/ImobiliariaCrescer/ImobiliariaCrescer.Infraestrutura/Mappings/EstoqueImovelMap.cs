using ImobiliariaCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ImobiliariaCrescer.Infraestrutura.Mappings
{
    public class EstoqueImovelMap : EntityTypeConfiguration<EstoqueImovel>
    {
        public EstoqueImovelMap()
        {
            ToTable("EstoqueImovel");

            HasRequired(x => x.Imovel)
                .WithMany()
                .HasForeignKey(x => x.IdImovel);

            HasRequired(x => x.Combo)
                .WithMany()
                .HasForeignKey(x => x.IdCombo);
        }
    }
}
