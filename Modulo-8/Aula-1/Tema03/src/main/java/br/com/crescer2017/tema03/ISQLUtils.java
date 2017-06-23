package br.com.crescer2017.tema03;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public interface ISQLUtils {
    void runFile(String filename) throws Exception;
    String executeQuery(String query) throws SQLException;
    void importCSV(File file) throws Exception;
    File exportCSV(String query) throws Exception;
}
