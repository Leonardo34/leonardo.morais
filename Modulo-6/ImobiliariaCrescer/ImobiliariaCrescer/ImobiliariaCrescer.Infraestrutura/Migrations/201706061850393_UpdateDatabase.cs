namespace ImobiliariaCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class UpdateDatabase : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.PedidosAdicionais",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        IdPedido = c.Int(nullable: false),
                        IdAdicional = c.Int(nullable: false),
                        Quantidade = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Adicionais", t => t.IdAdicional, cascadeDelete: true)
                .ForeignKey("dbo.Pedidos", t => t.IdPedido, cascadeDelete: true)
                .Index(t => t.IdPedido)
                .Index(t => t.IdAdicional);
            
            AddColumn("dbo.Adicionais", "Quantidade", c => c.Int(nullable: false));
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.PedidosAdicionais", "IdPedido", "dbo.Pedidos");
            DropForeignKey("dbo.PedidosAdicionais", "IdAdicional", "dbo.Adicionais");
            DropIndex("dbo.PedidosAdicionais", new[] { "IdAdicional" });
            DropIndex("dbo.PedidosAdicionais", new[] { "IdPedido" });
            DropColumn("dbo.Adicionais", "Quantidade");
            DropTable("dbo.PedidosAdicionais");
        }
    }
}
