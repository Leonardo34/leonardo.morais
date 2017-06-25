package br.com.crescer2017.tema4.repository;

import br.com.crescer2017.tema4.models.Locacao;
import javax.persistence.EntityManager;

public class LocacaoDao extends GenericDao<Locacao, Long> {
    public LocacaoDao(EntityManager entityManager) {
        super(Locacao.class, entityManager);
    }
}
