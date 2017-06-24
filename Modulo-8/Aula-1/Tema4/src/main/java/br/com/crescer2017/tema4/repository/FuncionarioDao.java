package br.com.crescer2017.tema4.repository;

import br.com.crescer2017.tema4.models.Funcionario;

public class FuncionarioDao extends GenericDao<Funcionario, Long> {
    public FuncionarioDao() {
        super(Funcionario.class);
    }
}
