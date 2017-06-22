package br.com.crescer.aula3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.LongStream;

public class ExercicioAula3 {
    public static void main(String[] args) {
        try (final Connection connection = ConnectionUtils.getConnection()) {
            TesteDao testeDao = new TesteDao();
            testeDao.drop();
            testeDao.create();
            testeDao.insert();
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }
}
