import java.util.Scanner;

public class programa6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Insertar el valor de compra:");
        double purchaseValue = input.nextDouble();

        System.out.println("Insertar tu sexo (1. Mujer || 2. Hombre):");
        int sex = input.nextInt();

        System.out.println("Insertar tu nombre:");
        String name = input.next();

        System.out.println("Insertar tu edad:");
        int age = input.nextInt();

        String nameAux = name.toLowerCase();
        if(sex == 1){
            if(nameAux.equals("teresita") || nameAux.equals("tere") || nameAux.equals("teresa")){
                if(age >= 16 && age <= 22) {
                    purchaseValue = purchaseValue * 0.93;
                }else{
                    System.out.println("No se aplica descuento");    
                }         
            }else{
                System.out.println("No se aplica descuento");
            }
        }else{
            System.out.println("No se aplica descuento");
        }

        System.out.println("Monto a pagar: " + purchaseValue);


    }
}