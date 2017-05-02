-- Exercicio 1

select *,
	DATEDIFF(MONTH, Data_Inicio_Prev, Data_Fim_Prev) as 'Tempo Previsto(em meses)',
	DATEDIFF(MONTH, Data_Inicio_Real, Data_Fim_Real) as 'Tempo de duração Obra(em meses)'
	from Licitacao 
	where Data_Inicio_Real > Data_Inicio_Prev;

-- Exercicio 2

select TOP(10) Empresa_Licitante, 
	SUM(Valor_Realizado) as FaturamentoTotal,
	SUM(Valor_Realizado) / SUM(Profissionais) as CustoPorProfissional
	from Licitacao 
	group by Empresa_Licitante
	order by FaturamentoTotal DESC;

-- Exercicio 3

select TOP(10) Municipio,
	SUM(Imposto_Municipal) as ImpostosArrecadados 
	from Licitacao 
	group by Municipio
	order by ImpostosArrecadados DESC;

-- Exercicio 4

SET DATEFIRST 1;

select * from Licitacao where DATEPART(WEEKDAY, Data_Inicio_Real) >= 6;

-- Exercicio 5

select Empresa_Licitante	
	from Licitacao
	group by Empresa_Licitante
	having SUM(Valor_Realizado) > MAX(Faturamento_1Ano_Anterior) / 2;

-- Exercicio 6

select *, CustoReal = CASE
	WHEN Esfera = 'Federal' THEN (Valor_Realizado - Imposto_Federal)
	WHEN Esfera = 'Estadual' THEN (Valor_Realizado - Imposto_Estadual)
	WHEN Esfera = 'Municipal' THEN (Valor_Realizado - Imposto_Municipal)
	END
	from Licitacao;

-- Exercicio 7

select Valor_Realizado from Licitacao where Identificador = 17255 OR Identificador = 17120;

/* A Diferença do orçamento entre os dois projetos é pequena, considerando seus valores totais






