package br.com.crescer2017.tema02;

import br.com.crescer2017.tema01.StringUtils;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileUtils implements IFileUtils {
    private final StringUtils stringUtils = new StringUtils();

    @Override
    public boolean mk(String string) throws IOException {
        File file = new File(string);
        String fileExtension = stringUtils.getFileExtension(string);
        if (fileExtension.isEmpty()) {
            return file.mkdir();
        }
        return file.createNewFile();
    }

    @Override
    public boolean rm(String string) throws IOException {
        return new File(string).delete();
    }

    @Override
    public String ls(String string) throws IOException {
        StringBuilder nomesArq = new StringBuilder();
        File folder = new File(string);
        if (folder.isDirectory()) {
            ls(nomesArq, folder);
        } else {
            nomesArq.append(folder.getAbsolutePath());
        }
        return nomesArq.toString();
    }

    @Override
    public boolean mv(String in, String out) throws IOException {
        File inFile = new File(in);
        File outFile = new File(out);
        if (inFile.isDirectory() || outFile.isDirectory()) {
            throw new IOException();
        }
        Files.move(inFile.toPath(), outFile.toPath());    
        return true;
    }
    
    private void ls(StringBuilder builder, File file) throws IOException {
        for (File each : file.listFiles()) {
            if (each.isDirectory()) {
                ls(builder, each);
            } else {
                builder.append(each.getAbsolutePath() + "\n");
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        FileUtils utils = new FileUtils();
        System.out.println(utils.ls("C:\\Users\\Leonardo\\Pictures\\Pat2Math Prints"));
        System.out.println(utils.ls("C:\\Users\\Leonardo\\Pictures\\Pat2Math Prints\\teste.txt"));
        System.out.println(utils.mk("C:\\Users\\Leonardo\\Pictures\\Pat2Math Prints\\Dirteste"));
    }
}
