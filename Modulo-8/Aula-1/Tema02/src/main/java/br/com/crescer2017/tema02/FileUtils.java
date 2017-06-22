package br.com.crescer2017.tema02;

import java.io.File;
import java.io.IOException;

public class FileUtils implements IFileUtils {

    @Override
    public boolean mk(String string) throws IOException {
        return new File(string).createNewFile();
    }

    @Override
    public boolean rm(String string) {
        return new File(string).delete();
    }

    @Override
    public String ls(String string) throws IOException {
        StringBuilder files = new StringBuilder();
        ls(files, new File(string));
        return files.toString();
    }

    @Override
    public boolean mv(String in, String out) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void ls(StringBuilder builder, File file) throws IOException {
        for (File each : file.listFiles()) {
            if (each.isDirectory()) {
                ls(builder, each);
            } else {
                builder.append(each.getAbsolutePath());
            }
        }
    }
}
