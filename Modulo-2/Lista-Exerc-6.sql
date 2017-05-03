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

select UF, COUNT(1)
	from Cidade CID
	inner join Cliente CLI on CID.IDCidade = CLI.IDCidade
	group by CID.UF;