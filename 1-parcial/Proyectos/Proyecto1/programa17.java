import java.util.Scanner;

public class programa17 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int array[] = new int[10];

        for(int i = 0; i < 10; i++) {
            System.out.println("Inserta un número entero: ");
            array[i] = input.nextInt();
            clearScreen();
        }

        for(int i = 0; i < 10; i++) {
            System.out.printf("[" + array[i] + "] ");
        }
        System.out.printf("\n");
        
    }

    public static void clearScreen(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
}