package br.com.crescer.aula3;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CidadeDAO implements Dao<Cidade> {
    private static final String INSERT_CIDADE = "INSERT INTO CIDADE (ID, NOME, ESTADO) VALUES (?,?, ?)";
    private static final String UPDATE_CIDADE = "UPDATE CIDADE SET NOME = ?, ESTADO = ? WHERE ID = ?";
    private static final String DELETE_CIDADE = "DELETE FROM CIDADE WHERE ID = ?";
    private static final String LOAD_CIDADE = "SELECT * FROM CIDADE WHERE ID = ?";
    
    @Override
    public void insert(Cidade cidade) throws SQLException {
        try (final PreparedStatement preparedStatement
                = ConnectionUtils.getConnection().prepareStatement(INSERT_CIDADE)) {

            preparedStatement.setLong(1, cidade.getId());
            preparedStatement.setString(2, cidade.getNome());
            preparedStatement.setString(3, cidade.getEstado().getNome());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void update(Cidade cidade) throws SQLException {
        try (final PreparedStatement preparedStatement
                = ConnectionUtils.getConnection().prepareStatement(UPDATE_CIDADE)) {
            preparedStatement.setString(1, cidade.getNome());
            preparedStatement.setInt(2, cidade.getEstado().getId());
            preparedStatement.setLong(3, cidade.getId());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void delete(Cidade cidade) throws SQLException {
        try (final PreparedStatement preparedStatement
                = ConnectionUtils.getConnection().prepareStatement(DELETE_CIDADE)) {
            preparedStatement.setLong(1, cidade.getId());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public Cidade loadBy(Long id) throws SQLException {
        Cidade cidade = new Cidade();
        try (final PreparedStatement preparedStatement
                = ConnectionUtils.getConnection().prepareStatement(LOAD_CIDADE)) {
            preparedStatement.setLong(1, id);
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    cidade.setId((int)resultSet.getLong("ID"));
                    cidade.setNome(resultSet.getString("NOME"));
                }
            }
        }
        return cidade;
    }  
}
