import java.util.Scanner;

public class programa3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		//SEGUNDOS
		int segundos = in.nextInt();
		System.out.println("Segundos = " + segundos);

		//MINUTOS, SEGUNDOS
		int minutos = segundos / 60;
		segundos = segundos % 60;
		System.out.println("Minutos = " + minutos + ", segundos = " + segundos);

		//HORAS, MINUTOS, SEGUNDOS
		int horas = minutos / 60;
		minutos = minutos % 60;
		segundos = segundos % 60;
		System.out.println("Horas= " + horas + ", minutos = " + minutos + ", segundos = " + segundos);
	}
}
