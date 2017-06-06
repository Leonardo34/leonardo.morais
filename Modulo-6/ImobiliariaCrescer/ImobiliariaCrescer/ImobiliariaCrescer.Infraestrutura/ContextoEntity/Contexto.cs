using ImobiliariaCrescer.Infraestrutura.Entidades;
using ImobiliariaCrescer.Infraestrutura.Mappings;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ImobiliariaCrescer.Infraestrutura.ContextoEntity
{
    public class Contexto : DbContext
    {
        public Contexto() : base("Server=191.232.191.228; Database=aluno04db; User id=leonardo.morais; Password=123456")
        { }

        public DbSet<Usuario> Usuarios { get; set; }
        public DbSet<Permissao> Permissoes { get; set; }
        public DbSet<Adicional> Adicionais { get; set; }
        public DbSet<Cliente> Clientes { get; set; }
        public DbSet<Combo> Combos { get; set; }
        public DbSet<Imovel> Imoveis { get; set; }
        public DbSet<Pedido> Pedidos { get; set; }
        public DbSet<EstoqueImovel> Estoques { get; set; }
        public DbSet<PedidoAdicional> PedidosAdicionais { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new UsuarioMap());
            modelBuilder.Configurations.Add(new PermissaoMap());
            modelBuilder.Configurations.Add(new AdicionalMap());
            modelBuilder.Configurations.Add(new ClienteMap());
            modelBuilder.Configurations.Add(new ComboMap());
            modelBuilder.Configurations.Add(new ImovelMap());
            modelBuilder.Configurations.Add(new PedidoMap());
            modelBuilder.Configurations.Add(new EstoqueImovelMap());
            modelBuilder.Configurations.Add(new PedidoAdicionalMap());
        }
    }
}
