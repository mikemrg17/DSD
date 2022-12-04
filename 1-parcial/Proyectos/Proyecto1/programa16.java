import java.util.Scanner;

public class programa16 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String numbers;
        int number;
        int opt;
        double result;

        numbers = "";
        number = 0;
        result = 0.0;

        while(true){
            System.out.println("0. Insertar número | 1. Salir");
            opt = input.nextInt();
            if(opt == 1)
                break;

            do{
                System.out.println("Número ( != 0 ):");
                number = input.nextInt();
            }while(number == 0);
            result += Math.pow(number, 2);
            numbers += number + "^2 + ";
        }

        System.out.println(numbers + " = " + result);
    }
}