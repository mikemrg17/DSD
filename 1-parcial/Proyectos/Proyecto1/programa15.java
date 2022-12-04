import java.util.Scanner;

public class programa15 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int random_num = (int)Math.floor(Math.random()*(100-1+1)+1);
        int guess;

        do{
            System.out.println("Adivina el número:");
            guess = input.nextInt();
            clearScreen();
            if(guess < random_num)
                System.out.println("Tu número es menor");
            else
                System.out.println("Tu número es mayor:");
        }while(guess != random_num && guess != 0);
        
        clearScreen();
        if(guess != 0)
            System.out.println("ADIVINASTE!!!");
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
}