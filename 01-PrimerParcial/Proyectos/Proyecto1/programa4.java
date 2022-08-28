import java.util.Scanner;

public class programa4 {
	public static void main(String[] args) {
		Scanner	input = new Scanner(System.in);

		int a, b, c;
		System.out.println("Inserte a: ");
		a = input.nextInt();
		System.out.println("Inserte b: ");
		b = input.nextInt();
		System.out.println("Inserte c: ");
		c = input.nextInt();

		double x1, x2;

		if((4*a*c) > Math.pow(b,2)){
			System.out.println("No hay soluciones reales");
		}else{
			x1 = (0 - b - Math.sqrt(Math.pow(b,2) - 4*a*c)) / (2 * a);
			x2 = (0 - b + Math.sqrt(Math.pow(b,2) - 4*a*c)) / (2 * a);
			System.out.println("X1 = " + x1);
			System.out.println("X2 = " + x2);
		}
	}
}
