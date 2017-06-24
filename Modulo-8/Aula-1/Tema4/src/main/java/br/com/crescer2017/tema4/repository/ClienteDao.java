package br.com.crescer2017.tema4.repository;

import br.com.crescer2017.tema4.models.Cliente;

public class ClienteDao extends GenericDao<Cliente, Long> {
    public ClienteDao() {
        super(Cliente.class);
    }
}
