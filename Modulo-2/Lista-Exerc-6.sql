-- Exercicio 1

select * from Cliente;

select SUBSTRING(Nome, 1, CHARINDEX(' ', Nome) - 1) as PrimeiroNome,
	COUNT(1) as TotalOcorrencias 
	from Cliente
	group by SUBSTRING(Nome, 1, CHARINDEX(' ', Nome) - 1)
	order by TotalOcorrencias DESC;

-- Exercicio 2

select COUNT(*) as Quantidade,
	SUM(ValorPedido) as ValorTotal
	from Pedido
	where MONTH(DataPedido) = 4 AND YEAR(DataPedido) = 2017;

-- Exercicio 3

Select * from (select TOP(1) UF, COUNT(1) as Quantidade
	from Cidade CID
	inner join Cliente CLI on CID.IDCidade = CLI.IDCidade
	group by CID.UF
	order by Quantidade) as Tabela1
	Union
	Select * from (select TOP(1) UF, COUNT(1) as Quantidade
	from Cidade CID
	inner join Cliente CLI on CID.IDCidade = CLI.IDCidade
	group by CID.UF
	order by Quantidade DESC)
	as Tabela2;

-- Exercicio 4

insert into Produto(Nome, PrecoCusto, PrecoVenda, Situacao) 
	values('Galocha Maragato', 35.67, 77.95, 'A');

-- Exercicio 5
