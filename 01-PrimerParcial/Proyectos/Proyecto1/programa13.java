import java.util.Scanner;

public class programa13 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Cadena: ");
        String string = input.next();

        for(int i = string.length() - 1; i >= 0; i--){
            System.out.printf(string.charAt(i) + "");
        }
        System.out.printf("\n");
    }
}