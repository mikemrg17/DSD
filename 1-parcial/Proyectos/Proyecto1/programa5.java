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
                    System.out.println("Calificación: A");
                }else if(grade >= 80 && grade <= 89){
                    System.out.println("Calificación: B");
                }else if(grade >= 60 && grade <= 79){
                    System.out.println("Calificación: C");
                }else{
                    System.out.println("Calificación: F");
                }
                break;
            
            case 2:
                System.out.println("Formato (Muy Bien, Bien, Suficiente, No suficiente)");
                if(grade >= 90 && grade <= 100) {
                    System.out.println("Calificación: Muy Bien");
                }else if(grade >= 80 && grade <= 89){
                    System.out.println("Calificación: Bien");
                }else if(grade >= 60 && grade <= 79){
                    System.out.println("Calificación: Suficiente");
                }else{
                    System.out.println("Calificación: No Suficiente");
                }
                break;
            
            default: break;
        }

    }
}