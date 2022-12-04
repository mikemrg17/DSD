import java.util.Scanner;

public class programa3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		//SECONDS
		System.out.println("Introduce los segundos:");
		int seconds = input.nextInt();
		System.out.println(seconds + " segundos");

		//MINUTES, SECONDS
		int minutes = seconds / 60;
		seconds = seconds % 60;
		System.out.println(minutes + " minutos, " + seconds +  " segundos");

		//HOURS, MINUTES, SECONDS
		int hours = minutes / 60;
		minutes = minutes % 60;
		seconds = seconds % 60;
		System.out.println(hours + " horas, " + minutes +  " minutos, "  + seconds + " segundos");
	}
}
