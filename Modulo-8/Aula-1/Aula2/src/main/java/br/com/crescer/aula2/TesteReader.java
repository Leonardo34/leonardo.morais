package br.com.crescer.aula2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TesteReader {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = 
                new BufferedReader(new FileReader("C:\\\\Users\\leonardo.morais\\teste.txt.txt"))) {
            while (true) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }
        }
    }
}
