package br.com.crescer2017.tema4.models.repository;

import br.com.crescer2017.tema4.models.Genero;

public class GeneroDao extends GenericDao<Genero, Long> {
    public GeneroDao() {
        super(Genero.class);
    }
}
