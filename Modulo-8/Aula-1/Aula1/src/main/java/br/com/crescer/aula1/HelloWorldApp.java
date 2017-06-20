package br.com.crescer.aula1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class HelloWorldApp {

    public static void main(String[] args) {
        StringBuffer estadosStr = new StringBuffer();
        List<Estado> estados = Arrays.asList(Estado.values());
        estados.sort(new EstadoComparator());
        for (Estado each : estados) {
            estadosStr.append(each.getNome() + ",");
        }
        estadosStr.deleteCharAt(estadosStr.length() - 1);
        System.out.println(estadosStr);
    }
    
    public static class EstadoComparator implements Comparator<Estado> {
        public int compare(Estado o1, Estado o2) {
            return o1.getNome().compareTo(o2.getNome());
        }
    }
}
