namespace ImobiliariaCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class UpdateDatabase1 : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.Adicionais", "PrecoPorDia", c => c.Decimal(nullable: false, precision: 18, scale: 2));
            AddColumn("dbo.Combos", "PrecoPorDia", c => c.Decimal(nullable: false, precision: 18, scale: 2));
            AddColumn("dbo.Pedidos", "TotalPrevisto", c => c.Decimal(precision: 18, scale: 2));
            AlterColumn("dbo.Pedidos", "TotalPago", c => c.Decimal(precision: 18, scale: 2));
            DropColumn("dbo.Adicionais", "Preco");
            DropColumn("dbo.Combos", "Preco");
        }
        
        public override void Down()
        {
            AddColumn("dbo.Combos", "Preco", c => c.Decimal(nullable: false, precision: 18, scale: 2));
            AddColumn("dbo.Adicionais", "Preco", c => c.Decimal(nullable: false, precision: 18, scale: 2));
            AlterColumn("dbo.Pedidos", "TotalPago", c => c.Decimal(nullable: false, precision: 18, scale: 2));
            DropColumn("dbo.Pedidos", "TotalPrevisto");
            DropColumn("dbo.Combos", "PrecoPorDia");
            DropColumn("dbo.Adicionais", "PrecoPorDia");
        }
    }
}
