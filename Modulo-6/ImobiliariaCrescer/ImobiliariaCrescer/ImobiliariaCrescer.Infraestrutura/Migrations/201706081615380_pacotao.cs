namespace ImobiliariaCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class pacotao : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Adicionais2",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                        PrecoPorDia = c.Decimal(nullable: false, precision: 18, scale: 2),
                        Quantidade = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Clientes2",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Cpf = c.String(),
                        Nome = c.String(),
                        Email = c.String(),
                        Endereco = c.String(),
                        DataNascimento = c.DateTime(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Combos2",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                        PrecoPorDia = c.Decimal(nullable: false, precision: 18, scale: 2),
                        Quartos = c.Int(nullable: false),
                        Banheiros = c.Int(nullable: false),
                        Cozinhas = c.Int(nullable: false),
                        Salas = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.EstoqueImovel2",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Quantidade = c.Int(nullable: false),
                        IdCombo = c.Int(nullable: false),
                        IdImovel = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Combos2", t => t.IdCombo, cascadeDelete: true)
                .ForeignKey("dbo.Imoveis2", t => t.IdImovel, cascadeDelete: true)
                .Index(t => t.IdCombo)
                .Index(t => t.IdImovel);
            
            CreateTable(
                "dbo.Imoveis2",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Tipo = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Pedidos2",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        DataVenda = c.DateTime(nullable: false),
                        DataEntregaPrevista = c.DateTime(nullable: false),
                        DataEntregaRealizada = c.DateTime(),
                        TotalPrevisto = c.Decimal(precision: 18, scale: 2),
                        TotalPago = c.Decimal(precision: 18, scale: 2),
                        IdCliente = c.Int(nullable: false),
                        IdCombo = c.Int(nullable: false),
                        IdImovel = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Clientes2", t => t.IdCliente, cascadeDelete: true)
                .ForeignKey("dbo.Combos2", t => t.IdCombo, cascadeDelete: true)
                .ForeignKey("dbo.Imoveis2", t => t.IdImovel, cascadeDelete: true)
                .Index(t => t.IdCliente)
                .Index(t => t.IdCombo)
                .Index(t => t.IdImovel);
            
            CreateTable(
                "dbo.PedidosAdicionais2",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Quantidade = c.Int(nullable: false),
                        IdAdicional = c.Int(nullable: false),
                        IdPedido = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Adicionais2", t => t.IdAdicional)
                .ForeignKey("dbo.Pedidos2", t => t.IdPedido)
                .Index(t => t.IdAdicional)
                .Index(t => t.IdPedido);
            
            CreateTable(
                "dbo.PermissaoUsuario2",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Usuario2",
                c => new
                    {
                        Id = c.Guid(nullable: false),
                        Nome = c.String(),
                        Email = c.String(),
                        Senha = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.PedidoAdicional2",
                c => new
                    {
                        IdPedido = c.Int(nullable: false),
                        IdAdicional = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.IdPedido, t.IdAdicional })
                .ForeignKey("dbo.Pedidos2", t => t.IdPedido, cascadeDelete: true)
                .ForeignKey("dbo.PedidosAdicionais2", t => t.IdAdicional, cascadeDelete: true)
                .Index(t => t.IdPedido)
                .Index(t => t.IdAdicional);
            
            CreateTable(
                "dbo.UsuarioPermissao2",
                c => new
                    {
                        IdUsuario = c.Guid(nullable: false),
                        IdPermissao = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.IdUsuario, t.IdPermissao })
                .ForeignKey("dbo.Usuario2", t => t.IdUsuario, cascadeDelete: true)
                .ForeignKey("dbo.PermissaoUsuario2", t => t.IdPermissao, cascadeDelete: true)
                .Index(t => t.IdUsuario)
                .Index(t => t.IdPermissao);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.UsuarioPermissao2", "IdPermissao", "dbo.PermissaoUsuario2");
            DropForeignKey("dbo.UsuarioPermissao2", "IdUsuario", "dbo.Usuario2");
            DropForeignKey("dbo.Pedidos2", "IdImovel", "dbo.Imoveis2");
            DropForeignKey("dbo.Pedidos2", "IdCombo", "dbo.Combos2");
            DropForeignKey("dbo.Pedidos2", "IdCliente", "dbo.Clientes2");
            DropForeignKey("dbo.PedidoAdicional2", "IdAdicional", "dbo.PedidosAdicionais2");
            DropForeignKey("dbo.PedidoAdicional2", "IdPedido", "dbo.Pedidos2");
            DropForeignKey("dbo.PedidosAdicionais2", "IdPedido", "dbo.Pedidos2");
            DropForeignKey("dbo.PedidosAdicionais2", "IdAdicional", "dbo.Adicionais2");
            DropForeignKey("dbo.EstoqueImovel2", "IdImovel", "dbo.Imoveis2");
            DropForeignKey("dbo.EstoqueImovel2", "IdCombo", "dbo.Combos2");
            DropIndex("dbo.UsuarioPermissao2", new[] { "IdPermissao" });
            DropIndex("dbo.UsuarioPermissao2", new[] { "IdUsuario" });
            DropIndex("dbo.PedidoAdicional2", new[] { "IdAdicional" });
            DropIndex("dbo.PedidoAdicional2", new[] { "IdPedido" });
            DropIndex("dbo.PedidosAdicionais2", new[] { "IdPedido" });
            DropIndex("dbo.PedidosAdicionais2", new[] { "IdAdicional" });
            DropIndex("dbo.Pedidos2", new[] { "IdImovel" });
            DropIndex("dbo.Pedidos2", new[] { "IdCombo" });
            DropIndex("dbo.Pedidos2", new[] { "IdCliente" });
            DropIndex("dbo.EstoqueImovel2", new[] { "IdImovel" });
            DropIndex("dbo.EstoqueImovel2", new[] { "IdCombo" });
            DropTable("dbo.UsuarioPermissao2");
            DropTable("dbo.PedidoAdicional2");
            DropTable("dbo.Usuario2");
            DropTable("dbo.PermissaoUsuario2");
            DropTable("dbo.PedidosAdicionais2");
            DropTable("dbo.Pedidos2");
            DropTable("dbo.Imoveis2");
            DropTable("dbo.EstoqueImovel2");
            DropTable("dbo.Combos2");
            DropTable("dbo.Clientes2");
            DropTable("dbo.Adicionais2");
        }
    }
}
