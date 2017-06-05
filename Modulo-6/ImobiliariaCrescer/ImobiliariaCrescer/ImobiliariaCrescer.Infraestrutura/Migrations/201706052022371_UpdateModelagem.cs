namespace ImobiliariaCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class UpdateModelagem : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Adicionais",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                        Preco = c.Decimal(nullable: false, precision: 18, scale: 2),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Clientes",
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
                "dbo.Combos",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                        Preco = c.Decimal(nullable: false, precision: 18, scale: 2),
                        Quartos = c.Int(nullable: false),
                        Banheiros = c.Int(nullable: false),
                        Cozinhas = c.Int(nullable: false),
                        Salas = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Imoveis",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Tipo = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Pedidos",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        IdCliente = c.Int(nullable: false),
                        DataVenda = c.DateTime(nullable: false),
                        DataEntregaPrevista = c.DateTime(nullable: false),
                        DataEntregaRealizada = c.DateTime(),
                        IdImovel = c.Int(nullable: false),
                        IdCombo = c.Int(nullable: false),
                        TotalPago = c.Decimal(nullable: false, precision: 18, scale: 2),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Clientes", t => t.IdCliente, cascadeDelete: true)
                .ForeignKey("dbo.Combos", t => t.IdCombo, cascadeDelete: true)
                .ForeignKey("dbo.Imoveis", t => t.IdImovel, cascadeDelete: true)
                .Index(t => t.IdCliente)
                .Index(t => t.IdImovel)
                .Index(t => t.IdCombo);
            
            CreateTable(
                "dbo.PedidoAdicional",
                c => new
                    {
                        IdPedido = c.Int(nullable: false),
                        IdAdicional = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.IdPedido, t.IdAdicional })
                .ForeignKey("dbo.Pedidos", t => t.IdPedido, cascadeDelete: true)
                .ForeignKey("dbo.Adicionais", t => t.IdAdicional, cascadeDelete: true)
                .Index(t => t.IdPedido)
                .Index(t => t.IdAdicional);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Pedidos", "IdImovel", "dbo.Imoveis");
            DropForeignKey("dbo.Pedidos", "IdCombo", "dbo.Combos");
            DropForeignKey("dbo.Pedidos", "IdCliente", "dbo.Clientes");
            DropForeignKey("dbo.PedidoAdicional", "IdAdicional", "dbo.Adicionais");
            DropForeignKey("dbo.PedidoAdicional", "IdPedido", "dbo.Pedidos");
            DropIndex("dbo.PedidoAdicional", new[] { "IdAdicional" });
            DropIndex("dbo.PedidoAdicional", new[] { "IdPedido" });
            DropIndex("dbo.Pedidos", new[] { "IdCombo" });
            DropIndex("dbo.Pedidos", new[] { "IdImovel" });
            DropIndex("dbo.Pedidos", new[] { "IdCliente" });
            DropTable("dbo.PedidoAdicional");
            DropTable("dbo.Pedidos");
            DropTable("dbo.Imoveis");
            DropTable("dbo.Combos");
            DropTable("dbo.Clientes");
            DropTable("dbo.Adicionais");
        }
    }
}
