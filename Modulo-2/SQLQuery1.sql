-- Exercicio 1

select * into CidadeAux from Cidade;

--Exercicio 2

truncate table CidadeAux;

select * into CidadeAux from Cidade where UF = 'RS';

select * from CidadeAux;

--Exercicio 3

Create table Produto (
	IDProduto int not null,
	NomeCurto varchar(10) not null,
	NomeDescritivo varchar(40) not null,
	DataCriacao datetime not null,
	LocalEstoque varchar(50) not null,
	Quantidade int not null,
	Preco decimal(9, 2) not null,
		constraint PK_Produto primary key (IDProduto)
);

--Exercicio 4

insert into Produto (IDProduto, NomeCurto, NomeDescritivo, DataCriacao, LocalEstoque, Quantidade, Preco)
	values (1, 'Caf�', 'Caf� Loco', getdate(), 'C�u', 8001, 500.49);

insert into Produto (IDProduto, NomeCurto, NomeDescritivo, DataCriacao, LocalEstoque, Quantidade, Preco)
	values (2, 'Chocolate', 'Chocolate meio amargo', getdate(), 'Arm�rio', 10, 5.99);

select * from Produto;