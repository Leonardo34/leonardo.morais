package br.com.crescer2017.tema4.repository;

import br.com.crescer2017.tema4.models.Cliente;
import javax.persistence.EntityManager;

public class ClienteDao extends GenericDao<Cliente, Long> {
    public ClienteDao(EntityManager entityManager) {
        super(Cliente.class, entityManager);
    }
}
