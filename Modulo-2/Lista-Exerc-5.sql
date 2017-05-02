-- Exercicio 1

select * from Empregado;

select E.NomeEmpregado as NomeEmpregado, 
	G.NomeEmpregado as NomeGerente,
	D.NomeDepartamento as Departamento
	from Empregado E 
	left join Empregado G on E.IDGerente = G.IDEmpregado
	left join Departamento D on E.IDDepartamento = D.IDDepartamento;

-- Exercicio 2

select TOP(1) E.NomeEmpregado, 
	D.NomeDepartamento,
	D.IDDepartamento 
	from Empregado E
	left join Departamento D on E.IDDepartamento = D.IDDepartamento
	order by Salario DESC;

-- Exercicio 3

select * into EmpregadoCopia from Empregado;


update Empregado 
	set Salario = Salario * 0.1730 
	where IDDepartamento in (Select IDDepartamento 
							from Departamento
							where Localizacao = 'SAO PAULO');

-- Exercicio 4

select Nome,
	UF
	from Cidade 
	group by Nome, UF
	having COUNT(Nome) > 1 AND COUNT(UF) > 1;

-- Exercicio 5

update Cidade
	set Nome = Nome + '*'
	where IDCidade in (select MAX(IDCidade)
							from Cidade 
							group by Nome, UF
							having COUNT(Nome) > 1 AND COUNT(UF) > 1);
