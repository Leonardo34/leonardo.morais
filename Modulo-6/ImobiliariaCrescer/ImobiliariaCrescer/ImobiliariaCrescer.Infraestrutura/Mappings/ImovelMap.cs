using ImobiliariaCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ImobiliariaCrescer.Infraestrutura.Mappings
{
    public class ImovelMap : EntityTypeConfiguration<Imovel>
    {
        public ImovelMap()
        {
            ToTable("Imoveis");

            HasMany(x => x.Estoques)
                .WithRequired(x => x.Imovel)
                .HasForeignKey(x => x.IdImovel);
        }
    }
}
