namespace ImobiliariaCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class UpdateControleEstoqueImoveis : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.EstoqueImovel",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        IdImovel = c.Int(nullable: false),
                        IdCombo = c.Int(nullable: false),
                        Quantidade = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Combos", t => t.IdCombo, cascadeDelete: true)
                .ForeignKey("dbo.Imoveis", t => t.IdImovel, cascadeDelete: true)
                .Index(t => t.IdImovel)
                .Index(t => t.IdCombo);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.EstoqueImovel", "IdImovel", "dbo.Imoveis");
            DropForeignKey("dbo.EstoqueImovel", "IdCombo", "dbo.Combos");
            DropIndex("dbo.EstoqueImovel", new[] { "IdCombo" });
            DropIndex("dbo.EstoqueImovel", new[] { "IdImovel" });
            DropTable("dbo.EstoqueImovel");
        }
    }
}
