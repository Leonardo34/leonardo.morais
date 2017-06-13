DECLARE
 CURSOR CID_DUPLICADAS IS
     Select Nome, 
            Uf,
            COUNT(1) as total
     From Cidade
     group by Nome, Uf
     having COUNT(1) > 1;
     
    CURSOR CLIENTES_RESIDENTES (pNomeCidade in varchar2, pUF in varchar2) IS
       Select cliente.Nome, 
            cliente.Bairro
         From   Cliente cliente
         inner join cidade c on c.IDCIDADE = cliente.IDCIDADE
         Where  c.NOME = pNomeCidade AND c.UF = pUF
         order by Nome;
BEGIN
   FOR reg IN CID_DUPLICADAS LOOP
     DBMS_OUTPUT.PUT_LINE( reg.nome || '-'|| reg.UF || '-' || reg.total);
     FOR cliente IN CLIENTES_RESIDENTES(reg.nome, reg.UF) LOOP
      DBMS_OUTPUT.PUT_LINE( cliente.nome || '-'|| cliente.bairro );
     END LOOP;
   END LOOP;
END;

CREATE OR REPLACE PROCEDURE atualizarValorPedido (id in NUMBER) IS
  CURSOR CID_DUPLICADAS IS
     Select IDPRODUTO,
            PRECOUNITARIO
     From PEDIDOITEM
     Where IDPRODUTO = id;   
BEGIN
 DBMS_OUTPUT.PUT_LINE('Ola');
END;

