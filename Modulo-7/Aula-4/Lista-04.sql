Create table LogAposta (
  IDLogAposta   integer not null,
  Usuario        varchar2(30),
  Data           date default sysdate,  
  Operacao       char(1) not null,
    constraint PK_LogAposta 
       primary key (IDLogCliente)
);

Create table LogNumeroAposta (
  IDLogNumeroAposta  integer not null,
  Usuario        varchar2(30),
  Data           date default sysdate,  
  Operacao       char(1) not null,
    constraint PK_LogNumeroAposta 
       primary key (IDLogNumeroAposta)
);

Create sequence sqLogAposta;

Create sequence sqLogNumeroAposta;

----------------------------------------------------------------------------------

create or replace
trigger TR_AUD1_LOG_APOSTA
    after insert or update or delete on NUMERO_APOSTA
Declare
  v_operacao char(1);
Begin

  if INSERTING then
     v_operacao := 'I';
  elsif UPDATING then
     v_operacao := 'U';       
  else
     v_operacao := 'D';
  end if;
  Insert into LogAposta (idlogaposta, data, usuario, operacao)
      values (sqLogAposta.nextval, sysdate, user, v_operacao);

End TR_AUD1_CLIENTE;

------------------------------------------------------------------------------------------

create or replace
trigger TR_AUD1_LOG_NUMERO_APOSTA
    after insert or update or delete on APOSTA
Declare
  v_operacao char(1);
Begin

  if INSERTING then
     v_operacao := 'I';
  elsif UPDATING then
     v_operacao := 'U';       
  else
     v_operacao := 'D';
  end if;
  Insert into LogNumeroAposta (idlognumeroaposta, data, usuario, operacao)
      values (sqLogNumeroAposta.nextval, sysdate, user, v_operacao);

End TR_AUD1_CLIENTE;

-------------------------------------------------------------------------------------------

