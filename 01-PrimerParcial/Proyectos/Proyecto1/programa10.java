import java.util.Scanner;

public class programa10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Inserta un número:");
        int number = input.nextInt();

        int factorial = 0;
        System.out.printf(number + " x ");
        for(int i = number - 1; i > 0; i--){
            number *= i;
            System.out.printf(i + " ");
            if(i != 1)
                System.out.printf("x ");
        }
        System.out.printf("\n");
        factorial = number;
        System.out.println("Factorial: " + factorial);
    }
}