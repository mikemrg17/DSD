import java.util.Scanner;

public class programa14 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Escribe un número:");
        int number = input.nextInt();

        System.out.printf(number + ", ");
        while(number < 150){
            number += 5;
            if(number > 150)
                break;
            else
                System.out.printf(number + ", ");
        }
        System.out.printf("\n");
    }
}