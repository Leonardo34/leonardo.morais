package br.com.crescer.aula1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class ExercData {
    public static void main(String[] args) {
        try (final Scanner scanner = new Scanner(System.in)) {
            System.out.println("Digite a data: ");
            String dataString = scanner.nextLine();
            SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dataFormat.parse(dataString));
            calendar.add(Calendar.DAY_OF_YEAR, scanner.nextInt());
            System.out.println(dataFormat.format(calendar.getTime()));
        } catch (Exception e) {
            //...
        }
    }
}
