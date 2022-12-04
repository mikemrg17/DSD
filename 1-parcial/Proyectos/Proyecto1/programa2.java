import java.util.Scanner;

public class programa2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//Sides
		int a, b, height;
		System.out.println("Inserte a: ");
		a = input.nextInt();
		System.out.println("Inserte b: ");
		b = input.nextInt();
		System.out.println("Inserte altura: ");
		height = input.nextInt();
		float trapezeArea;

		trapezeArea = ((float)(a + b) / 2) * height;
		System.out.println("Área del trapecio: " + trapezeArea);
	}
}
