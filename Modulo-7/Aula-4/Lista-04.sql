Create table LogAposta (
  IDLogAposta   integer not null,
  Usuario        varchar2(30),
  Data           date default sysdate,  
  Operacao       char(1) not null,
  IDAposta       integer not null,
    constraint PK_LogAposta 
       primary key (IDLogCliente)
);

Create table LogNumeroAposta (
  IDLogNumeroAposta  integer not null,
  Usuario        varchar2(30),
  Data           date default sysdate,  
  Operacao       char(1) not null,
  IDNumeroAposta       integer not null,
    constraint PK_LogNumeroAposta 
       primary key (IDLogNumeroAposta)
);

Create sequence sqLogAposta;

Create sequence sqLogNumeroAposta;

----------------------------------------------------------------------------------

create or replace
trigger TR_AUD1_LOG_NUMERO_APOSTA
    after insert or update or delete on NUMERO_APOSTA
Declare
  v_operacao char(1);
  v_IDNumero_Aposta number;
Begin

  if INSERTING then
     v_operacao := 'I';
     v_IDNumero_Aposta := :new.IDNumero_Aposta;
  elsif UPDATING then
     v_operacao := 'U';  
     v_IDNumero_Aposta := :old.IDNumero_Aposta;     
  else
     v_operacao := 'D';
     v_IDNumero_Aposta := :old.IDNumero_Aposta;
  end if;
  Insert into LogNumeroAposta (idlognumeroaposta, data, usuario, operacao, IDNumeroAposta)
      values (sqLogAposta.nextval, sysdate, user, v_operacao, v_IDNumero_Aposta);

End TR_AUD1_LOG_NUMERO_APOSTA;

------------------------------------------------------------------------------------------

create or replace
trigger TR_AUD1_LOG_APOSTA
    after insert or update or delete on APOSTA
Declare
  v_operacao char(1);
  v_IDAposta number;
Begin

  if INSERTING then
     v_operacao := 'I';
     v_IDAposta := :new.IDAposta;
  elsif UPDATING then
     v_operacao := 'U';
     v_IDAposta := :old.IDAposta;       
  else
     v_operacao := 'D';
     v_IDAposta := :old.IDAposta;
  end if;
  Insert into LogAposta (idlognumeroaposta, data, usuario, operacao, IDAposta)
      values (sqLogNumeroAposta.nextval, sysdate, user, v_operacao, v_IDAposta);

End TR_AUD1_LOG_APOSTA;

-------------------------------------------------------------------------------------------

