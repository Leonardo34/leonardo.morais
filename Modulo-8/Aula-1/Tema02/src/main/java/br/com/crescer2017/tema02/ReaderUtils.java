package br.com.crescer2017.tema02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderUtils implements IReaderUtils {

    @Override
    public String read(String string) throws IOException {
        StringBuilder conteudo = new StringBuilder();
        try (BufferedReader reader = 
                new BufferedReader(new FileReader(string))) {
            String line;
            while ((line = reader.readLine()) != null) {
                conteudo.append(line);
            }
        }
        return conteudo.toString();
    } 
}
