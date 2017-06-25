package br.com.crescer2017.tema4.repository;

import br.com.crescer2017.tema4.models.Genero;
import javax.persistence.EntityManager;

public class GeneroDao extends GenericDao<Genero, Long> {
    public GeneroDao(EntityManager entityManager) {
        super(Genero.class, entityManager);
    }
}
