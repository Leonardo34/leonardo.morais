package br.com.crescer.aula3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Teste {
    private static final String DML = "CREATE TABLE TESTE ( \n"
            + "  ID NUMBER(8) NOT NULL,\n"
            + "  NOME VARCHAR2(60) DEFAULT NULL, \n"
            + "  SIGLA VARCHAR2(10) DEFAULT NULL, \n"
            + "  CONSTRAINT TESTE_PK PRIMARY KEY (ID)  ENABLE \n"
            + ")";
    
    public static void main(String[] args) {
        final String url = "jdbc:oracle:thin:@localhost:1521:xe";
        final String user = "system";
        final String pass = "oracle";

        try (final Connection connection = 
                DriverManager.getConnection(url, user, pass)) {
            final String query = "SELECT * FROM CIDADE";
            try (final Statement statement = connection.createStatement()) {
              try (final ResultSet resultSet = statement.executeQuery(query)) {
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("nome"));
                }
              } catch (final SQLException e) {
                System.out.format("SQLException: %s", e);
              }
            } catch (final SQLException e) {
              System.out.format("SQLException: %s", e);
            }
        } catch (SQLException e) {
            System.out.format("SQLException: %s", e);
        }
        dml();
    }
    
    public static void dml() {
        final String url = "jdbc:oracle:thin:@localhost:1521:xe";
        final String user = "system";
        final String pass = "oracle";

        try (final Connection connection = DriverManager.getConnection(url, user, pass);
                final Statement statement = connection.createStatement();) {
            statement.executeQuery(DML);
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }
}
