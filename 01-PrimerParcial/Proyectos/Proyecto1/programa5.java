import java.util.Scanner;

public class programa5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Inserta tu calificación 0 - 100:");
        int grade = input.nextInt();

        int opt;
        System.out.println("Elige una opción:\n"
            + "1. (A, B, C, F)\n"
            + "2. (Muy Bien, Bien, Suficiente, No suficiente)"
        );

        opt = input.nextInt();

        switch(opt) {
            case 1:
                System.out.println("Formato (A, B, C, F)");
                if(grade >= 90 && grade <= 100) {
                    System.out.println("Grade: A");
                }else if(grade >= 80 && grade <= 89){
                    System.out.println("Grade: B");
                }else if(grade >= 60 && grade <= 79){
                    System.out.println("Grade: C");
                }else{
                    System.out.println("Grade: F");
                }
                break;
            
            case 2:
                System.out.println("Formato (Muy Bien, Bien, Suficiente, No suficiente)");
                if(grade >= 90 && grade <= 100) {
                    System.out.println("Grade: Muy Bien");
                }else if(grade >= 80 && grade <= 89){
                    System.out.println("Grade: Bien");
                }else if(grade >= 60 && grade <= 79){
                    System.out.println("Grade: Suficiente");
                }else{
                    System.out.println("Grade: No Suficiente");
                }
                break;
            
            default: break;
        }

    }
}