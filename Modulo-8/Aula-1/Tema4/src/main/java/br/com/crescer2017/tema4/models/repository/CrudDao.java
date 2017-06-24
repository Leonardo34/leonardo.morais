package br.com.crescer2017.tema4.models.repository;

import java.util.List;

public interface CrudDao<E, I> {
    E save(E e);
    void remove(E e);
    E loadById(I id);
    List<E> findAll(); 
}

