import java.util.Scanner;

public class programa8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Número 1:");
        int num1 = input.nextInt();

        System.out.println("Número 2:");
        int num2 = input.nextInt();

        if(num1%num2 == 0) {
            System.out.println(num1 + " es múltiplo de " + num2);
        }else{
            System.out.println(num1 + " no es múltiplo de " + num2);
        }

    }
}