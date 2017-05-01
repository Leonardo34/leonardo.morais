-- Exercicio 1

select IDEmpregado as ID,
	NomeEmpregado as Nome,
	DATEDIFF(HOUR, DataNascimento, DataAdmissao) / 8766 as IdadeAdmissao
	from Empregado
	where YEAR(DataAdmissao) = 1980;

-- Exercicio 2

select TOP (1) Cargo, 
	COUNT(1) as QuantidadeEmpregados
	from Empregado
	group by Cargo
	order by QuantidadeEmpregados DESC;

-- Exercicio 3

select UF as Estado,
	Count (1) as QuantidadeCid
	from Cidade
	group by UF
	order by QuantidadeCid DESC;

-- Exercicio 4

insert into Departamento values (50,'Inovação', 'SAO LEOPOLDO');

update Empregado set IDDepartamento = 50 where MONTH(DataAdmissao) = 12 AND Cargo != 'Atendente';






