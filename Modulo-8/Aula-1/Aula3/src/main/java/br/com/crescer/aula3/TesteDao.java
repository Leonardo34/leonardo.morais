
package br.com.crescer.aula3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.LongStream;

public class TesteDao {
    private static final String CREATE_TABLE = "CREATE TABLE TESTE ( \n"
            + "  ID NUMBER(8) NOT NULL,\n"
            + "  NOME VARCHAR2(60) DEFAULT NULL, \n"
            + "  CONSTRAINT TESTE_PK PRIMARY KEY (ID)  ENABLE \n"
            + ")";  
    private static final String DROP_TABLE = "DROP TABLE TESTE";
    private static final String INSERT = "INSERT INTO TESTE (ID, NOME) VALUES (?,?)";
    
    
    public void create() throws SQLException {
        try (final Connection connection = ConnectionUtils.getConnection()) {
            try (final Statement statement = connection.createStatement()) {
                statement.executeQuery(CREATE_TABLE);
            }
        }
    }
    
    public void drop() throws SQLException {
        try (final Connection connection = ConnectionUtils.getConnection()) {
            try (final Statement statement = connection.createStatement()) {
                statement.executeQuery(CREATE_TABLE);
            }
        }
    }
    
    public void insert() throws SQLException {
        try (final Connection connection = ConnectionUtils.getConnection();
                final PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
            final List<Long> list = LongStream.range(1, 1000).boxed().collect(toList());
            for (Long id : list) {
                preparedStatement.setLong(1, id);
                preparedStatement.setString(2, String.format("%s pessoa de 999", id));
                preparedStatement.executeUpdate();
            }
        }
    }
}
