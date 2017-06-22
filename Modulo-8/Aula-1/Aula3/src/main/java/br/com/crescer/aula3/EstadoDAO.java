package br.com.crescer.aula3;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EstadoDAO implements Dao<Estado> {
    private static final String INSERT_ESTADO = "INSERT INTO CIDADE (ID, NOME, UF, PAIS) VALUES (?,?,?,?)";
    private static final String UPDATE_ESTADO = "UPDATE ESTADO SET NOME = ?, UF = ?, PAIS = ? WHERE ID = ?";
    private static final String DELETE_ESTADO = "DELETE FROM ESTADO WHERE ID = ?";
    private static final String LOAD_ESTADO = "SELECT * FROM ESTADO WHERE ID = ?";
    
    @Override
    public void insert(Estado estado) throws SQLException {
        try (final PreparedStatement preparedStatement
                = ConnectionUtils.getConnection().prepareStatement(INSERT_ESTADO)) {
            preparedStatement.setLong(1, estado.getId());
            preparedStatement.setString(2, estado.getNome());
            preparedStatement.setString(3, estado.getUf());
            preparedStatement.setLong(4, estado.getPais().getId());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void update(Estado estado) throws SQLException {
        try (final PreparedStatement preparedStatement
                = ConnectionUtils.getConnection().prepareStatement(UPDATE_ESTADO)) {
            preparedStatement.setString(1, estado.getNome());
            preparedStatement.setString(2, estado.getUf());
            preparedStatement.setLong(3, estado.getPais().getId());
            preparedStatement.setLong(4, estado.getId());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void delete(Estado estado) throws SQLException {
        try (final PreparedStatement preparedStatement
                = ConnectionUtils.getConnection().prepareStatement(DELETE_ESTADO)) {
            preparedStatement.setLong(1, estado.getId());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public Estado loadBy(Long id) throws SQLException {
        Estado estado = new Estado();
        try (final PreparedStatement preparedStatement
                = ConnectionUtils.getConnection().prepareStatement(LOAD_ESTADO)) {
            preparedStatement.setLong(1, id);
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    estado.setId((int)resultSet.getLong("ID"));
                    estado.setNome(resultSet.getString("NOME"));
                    estado.setUf(resultSet.getString("UF"));
                }
            }
        }
        return estado;
    }
}
