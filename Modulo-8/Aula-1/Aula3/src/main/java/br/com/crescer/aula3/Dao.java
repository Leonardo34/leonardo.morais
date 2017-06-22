package br.com.crescer.aula3;

import java.sql.SQLException;

public interface Dao<T> {   
    void insert(T t) throws SQLException;
    void update(T t) throws SQLException;
    void delete(T t) throws SQLException;   
    T loadBy(Long id) throws SQLException;
}
