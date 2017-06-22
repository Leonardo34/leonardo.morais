package br.com.crescer2017.tema02;

import br.com.crescer2017.tema01.StringUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderUtils implements IReaderUtils {
    private final StringUtils stringUtils = new StringUtils();

    @Override
    public String read(String string) throws Exception {
        if (!stringUtils.getFileExtension(string).equals("txt")) {
            throw new Exception("O Arquivo lido deve ser do tipo txt");
        }
        StringBuilder conteudo = new StringBuilder();
        try (BufferedReader reader = 
                new BufferedReader(new FileReader(string))) {
            String line;
            while ((line = reader.readLine()) != null) {
                conteudo.append(line + "\n");
            }
        }
        return conteudo.toString();
    }
    
    public static void main(String[] args) throws Exception {
        ReaderUtils utils = new ReaderUtils();
        System.out.println(utils.read("C:\\Users\\leonardo.morais\\Documents\\leonardo.morais\\teste.txt"));
    }
}
