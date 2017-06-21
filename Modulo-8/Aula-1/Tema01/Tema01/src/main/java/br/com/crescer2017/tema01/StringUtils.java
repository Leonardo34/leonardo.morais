package br.com.crescer2017.tema01;

import java.text.Normalizer;
import java.util.Arrays;
import java.util.List;

public class StringUtils implements IStringUtils {
    public boolean isEmpty(String string) {
        return string == null || string.replaceAll(" ", "").isEmpty();
    }
    
    public String inverter(String string) {
        StringBuilder stringInvertida = new StringBuilder();
        for (int i = string.length() - 1; i >= 0; i--) {
            stringInvertida.append(string.charAt(i));
        }
        return stringInvertida.toString();
    }
    
    public int contaVogais(String string) {
        String normalized = normalize(string);
        
        return (int) normalized.chars()
            .mapToObj(c -> Character.valueOf((char)c))
            .filter(c -> c.toString().matches("[aeiou]"))
            .count();
    }
    
    public boolean isPalindromo(String string) {
        String normalized = normalize(string).replaceAll(" ", "").toLowerCase();
        return isPalindromo(normalized, 0, normalized.length() - 1);
    }
    
    private boolean isPalindromo(String string, int base, int limit) {
        if (base >= limit) {
            return true;
        }
        if (string.charAt(base) != string.charAt(limit)) {
            return false;
        }
        return isPalindromo(string, ++base, --limit);
    }
    
    private String normalize(String nome) {
        return Normalizer.normalize(nome, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }
}