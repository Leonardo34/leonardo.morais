package br.com.crescer2017.tema03;

import br.com.crescer.aula3.ConnectionUtils;
import br.com.crescer2017.tema02.IReaderUtils;
import br.com.crescer2017.tema02.IWriterUtils;
import br.com.crescer2017.tema02.ReaderUtils;
import br.com.crescer2017.tema02.WriterUtils;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class SQLUtils implements ISQLUtils {
    @Override
    public void runFile(String filename) throws Exception {
        IReaderUtils readerUtils = new ReaderUtils();
        String querys = readerUtils.read(filename);
        for (String each : querys.split(";")) {
            insert(each);
        }
    }

    @Override
    public String executeQuery(String query) throws SQLException {
        StringBuilder queryResult = new StringBuilder();
        try (final PreparedStatement preparedStatement
                = ConnectionUtils.getConnection().prepareStatement(query)) {
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                appendTableInfo(queryResult, resultSet);
                appendQueryResponse(queryResult, resultSet);
            }
        }
        return queryResult.toString();
    }
    
    private void appendTableInfo(StringBuilder string, ResultSet resultSet) 
            throws SQLException {
        ResultSetMetaData meta = resultSet.getMetaData();
        for (int i = 1; i <= meta.getColumnCount(); i++) {
            string.append(meta.getColumnName(i) + "\t");
        }
        string.append("\n");
    }
    
    private void appendQueryResponse(StringBuilder string, ResultSet resultSet) 
            throws SQLException {
        ResultSetMetaData meta = resultSet.getMetaData();
        while (resultSet.next()) {
            for (int i = 1; i <= meta.getColumnCount(); i++) {
                string.append(resultSet.getObject(i) + "\t");
            }
            string.append("\n");
        }
    } 

    @Override
    public void importCSV(File file) throws Exception {
        IReaderUtils readerUtils = new ReaderUtils();
        String conteudoArquivo = readerUtils.read(file.getAbsolutePath());
        String nomeTabela = removeExtensionName(file.getName());
        String[] linhasArquivo = conteudoArquivo.split("\n");
        String colunas = String.join(",", linhasArquivo[0].split(";"));
        
        for (int i = 1; i < linhasArquivo.length; i++) {
            String values = toSQLValues(linhasArquivo[i].split(";"));
            insert(String.format("INSERT INTO %s(%s) VALUES(%s)", nomeTabela, colunas, values));
        }
    }
    
    private String removeExtensionName(String fileName) {
        return fileName.substring(0, fileName.lastIndexOf("."));
    }
    
    private String toSQLValues(String[] values) {
        for (int i = 0; i < values.length; i++) {
            values[i] = String.format("'%s'", values[i]);
        }
        return String.join(",", values);
    }
    
    private void insert(String query) throws SQLException {
        try (final PreparedStatement preparedStatement = 
                ConnectionUtils.getConnection().prepareStatement(query)) {
            preparedStatement.executeUpdate();
        } 
    }

    @Override
    public File exportCSV(String query) throws Exception {
        IWriterUtils writerUtils = new WriterUtils();
        String queryResult = executeQuery(query);
        String path = "export/export.txt";
        writerUtils.write(path, queryResult.replaceAll("\t", ";"));
        return new File(path);
    }
    
    public static void main(String[] args) throws Exception {
        SQLUtils utils = new SQLUtils();
        System.out.println(utils.executeQuery("SELECT * FROM PAIS"));
        //utils.importCSV(new File("pais.txt"));
        //utils.exportCSV("SELECT * FROM PAIS");
        utils.runFile("C:\\Users\\Leonardo\\Pictures\\leonardo.morais\\Modulo-8\\Aula-1\\pais.txt");
    }
}
