package br.com.crescer.aula1;

public class HelloWorldApp {

    public static void main(String[] args) {
        StringBuffer estados = new StringBuffer();
        for (Estado each : Estado.values()) {
            estados.append(each.getNome() + ",");
        }
        estados.deleteCharAt(estados.length() - 1);
        System.out.println(estados);
    }
}
