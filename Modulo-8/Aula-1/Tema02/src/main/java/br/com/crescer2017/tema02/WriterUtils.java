package br.com.crescer2017.tema02;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterUtils implements IWriterUtils {

    @Override
    public void write(String file, String conteudo) throws IOException {
        try (BufferedWriter writer = 
                new BufferedWriter(new FileWriter(file))) {
            writer.write(conteudo);
        }
    }
    
    public static void main(String[] args) throws IOException {
        WriterUtils utils = new WriterUtils();
        utils.write("C:\\Users\\Leonardo\\doc\\teste.txt", "TESTESTETSTETE");
    }
}
