import java.util.Scanner;

public class programa10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Inserta un número:");
        int number = input.nextInt();

        int factorial = 0;
        System.out.printf(number + "X");
        for(int i = number - 1; i > 0; i--){
            number *= i;
            System.out.printf(i + "X");
        }
        System.out.printf("\n");
        factorial = number;
        System.out.println("Factorial: " + factorial);
    }
}