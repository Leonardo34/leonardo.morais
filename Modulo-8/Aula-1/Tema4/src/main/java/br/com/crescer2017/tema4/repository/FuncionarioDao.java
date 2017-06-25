package br.com.crescer2017.tema4.repository;

import br.com.crescer2017.tema4.models.Funcionario;
import javax.persistence.EntityManager;

public class FuncionarioDao extends GenericDao<Funcionario, Long> {
    public FuncionarioDao(EntityManager entityManager) {
        super(Funcionario.class, entityManager);
    }
}
