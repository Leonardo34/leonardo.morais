-- Exercicio 1

select * into CidadeAux from Cidade;

--Exercicio 2

truncate table CidadeAux;

select * from CidadeAux;

--Exercicio 3

Create table Produto (
	IDProduto int not null,
	NomeCurto varchar(10) not null,
	NomeDescritivo varchar(40) not null,
	DataCriacao datetime not null,
	LocalEstoque varchar(50),
	Quantidade int,
		constraint PK_Produto primary key (IDProduto)
);

--Exercicio 4

insert into Produto (IDProduto, NomeCurto, NomeDescritivo, DataCriacao, LocalEstoque, Quantidade)
	values (1, 'Café', 'Café Loco', convert(datetime, '1980/12/17', 111), 'Céu', 8001);

insert into Produto (IDProduto, NomeCurto, NomeDescritivo, DataCriacao, LocalEstoque, Quantidade)
	values (2, 'Chocolate', 'Chocolate meio amargo', convert(datetime, '2017/01/01', 111), 'Armário', 10);

select * from Produto;