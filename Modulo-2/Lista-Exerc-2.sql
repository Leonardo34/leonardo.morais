-- Exercicio 1

select IDEmpregado, NomeEmpregado from Empregado order by DataAdmissao;

-- Exercicio 2

select IDEmpregado,
	 NomeEmpregado, 
	 Comissao 
	 from Empregado 
	 where Comissao is null; 

-- Exercicio 3

select NomeEmpregado as Nome,
	(Salario * 13) as SalarioAnual,
	(Comissao * 12) as ComissaoAnual,
	(Salario * 13 + Comissao * 12) as RendaAnual
	from Empregado;

-- Exercicio 4

select IDEmpregado,
	NomeEmpregado,
	Cargo,
	Salario
	from Empregado
	where (Salario * 13) <= 18500 OR Cargo = 'Atendente';

select * from Empregado;
	 
	