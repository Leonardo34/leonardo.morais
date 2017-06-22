package br.com.crescer2017.tema02;

import java.io.IOException;

public interface IFileUtils {
    boolean mk(String string) throws IOException;
    boolean rm(String string) throws IOException;
    String ls(String string) throws IOException;
    boolean mv(String in, String out) throws IOException;
}
