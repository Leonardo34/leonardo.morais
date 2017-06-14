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

UPDATE PEDIDO SET VALORPEDIDO = (SELECT SUM(PRECOUNITARIO * QUANTIDADE)
                                  FROM PEDIDOITEM
                                  WHERE IDPEDIDO =: IDPEDIDO)
  WHERE IDPEDIDO =: IDPEDIDO;



DECLARE 

CURSOR Clientes IS
  SELECT IDCLIENTE 
    FROM PEDIDO
    WHERE MONTHS_BETWEEN(TO_DATE(sysdate), TO_DATE(pedido.DataPedido) <= 6;
BEGIN 
    FOR reg IN Clientes LOOP
       UPDATE CLIENTE SET SITUACAO = 'I' WHERE IDCLIENTE =  reg.IDCLIENTE;
    END LOOP;
END;

----------------------------------------------------------------------------
create or replace package pck_cidades as
  procedure ELIMINAR_CIDADES_REPETIDAS;
end;

create or replace package body pck_cidades as
  procedure ELIMINAR_CIDADES_REPETIDAS is 
      CURSOR CID_DUPLICADAS IS
        Select Nome, 
              Uf,
              COUNT(1) as total
        From Cidade
        group by Nome, Uf
        having COUNT(1) > 1;
      menorIdCidadeDuplicada CIDADE.IDCIDADE%type; 
      
      CURSOR TODAS_CID_DUPLICADAS(pNomeCidade in varchar2, pUF in varchar2) is
        Select IDCidade
        from Cidade
        where Nome = pNomeCidade AND UF = pUF;
      
      CURSOR CLIENTES_CIDADE(pIdCidade in number) is 
        Select IDCliente 
        from Cliente 
        Where IDCidade = pIdCidade;
    begin
      FOR reg IN CID_DUPLICADAS LOOP
        Select MIN(IDCIDADE)
          Into menorIdCidadeDuplicada
          From Cidade
          where Nome = reg.Nome AND UF = reg.UF;
          FOR cid IN TODAS_CID_DUPLICADAS(reg.Nome, reg.UF) LOOP
            FOR cliente IN CLIENTES_CIDADE(cid.IDCidade) LOOP
              UPDATE CLIENTE SET IDCIDADE = menorIdCidadeDuplicada WHERE IDCLIENTE = cliente.IDCliente;
            END LOOP;
          END LOOP;
      END LOOP;
    end ELIMINAR_CIDADES_REPETIDAS;
  end;
begin
  pck_cidades.ELIMINAR_CIDADES_REPETIDAS;
end;
