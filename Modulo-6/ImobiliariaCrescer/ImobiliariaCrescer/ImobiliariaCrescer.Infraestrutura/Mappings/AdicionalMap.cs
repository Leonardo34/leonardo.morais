
using ImobiliariaCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ImobiliariaCrescer.Infraestrutura.Mappings
{
    public class AdicionalMap : EntityTypeConfiguration<Adicional>
    {
        public AdicionalMap()
        {
            ToTable("Adicionais2");
        }
    }
}
