package br.com.crescer.aula2;

import java.io.File;
import java.util.Arrays;
public class Run {
    public static void main(String[] args) {
        File file = new File(".");
        printFiles(file);
                
    }
    
    private static void printFiles(File file) {
        for (File each : file.listFiles()) {
            if (each.isDirectory()) {
                printFiles(each);
            } else {
                System.out.println(each.getAbsolutePath());
            }
        }
    }
}
