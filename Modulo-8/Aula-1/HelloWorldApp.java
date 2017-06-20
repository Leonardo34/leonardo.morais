import java.util.Scanner;

class HelloWorldApp {
  public static void main(String[] args) { 
	try (final Scanner scanner = new Scanner(System.in)) {
		System.out.println("Digite o numero: ");
		if (isPar(scanner.nextInt())) {
			System.out.println("Par");
		} else {
			System.out.println("Impar");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
  }
  
  public static boolean isPar(int n) {
	  return n % 2 == 0;
  }
}