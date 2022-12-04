import java.util.Scanner;

public class programa1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Inserte el radio del círculo: ");
		int radius = input.nextInt(); //Circle radius
		System.out.println("Inserte la altura: ");
		int height = input.nextInt(); //Height

		double circleArea = Math.PI * Math.pow(radius, 2);

		System.out.println("Radio: " + radius);
		System.out.println("Altura: " + height);
	
		double coneVolume = (circleArea * height)/3;
		System.out.format("El volumen del cono es: %.4f\n", coneVolume);
		double cylinderVolume = circleArea * height;
		System.out.format("El volumen del cilindro es: %.4f\n", cylinderVolume);
		double volumeDifference = cylinderVolume - coneVolume;
		System.out.format("Diferencia de volúmenes %.4f\n", volumeDifference);
	}
}
