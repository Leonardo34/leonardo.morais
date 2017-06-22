package br.com.crescer2017.tema02;

import br.com.crescer2017.tema01.StringUtils;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterUtils implements IWriterUtils {
    private final StringUtils stringUtils = new StringUtils();

    @Override
    public void write(String file, String conteudo) throws Exception {
        if (!stringUtils.getFileExtension(file).equals("txt")) {
            throw new Exception("O Arquivo a ser gravado deve ser do tipo txt");
        }
        try (BufferedWriter writer = 
                new BufferedWriter(new FileWriter(file))) {
            writer.write(conteudo);
        }
    }
    
    public static void main(String[] args) throws Exception {
        WriterUtils utils = new WriterUtils();
        utils.write("C:\\Users\\Leonardo\\doc\\teste.txt", "TESTESTETSTETE");
    }
}
