import java.util.Scanner;

public class programa7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Inserta la cantidad kW:");
        int kW = input.nextInt();

        System.out.println("Tipo de contrado (1. Hogar | 2. Negocio)");
        int type = input.nextInt();

        double payment = 0.0;

        switch(type){
            case 1:
                System.out.println("Hogar");
                if(kW >= 0 && kW >= 250){
                    payment += 250 * 0.65;
                }else if(kW >= 0 && kW <= 250){
                    payment = (250 - kW) * 0.65;
                }

                if(kW >= 251 && kW >= 500){
                    payment += (500 - 250) * 0.85;
                }else if(kW >= 251 && kW <= 500){
                    payment += (kW - 250) * 0.85;
                }

                if(kW >= 501 && kW >= 1200){
                    payment += (1200 - 500) * 1.50;
                }else if(kW >= 500 && kW <= 1200){
                    payment += (kW - 500) * 1.50;
                }

                if(kW >= 1201 && kW >= 2100){
                    payment += (2100 - 1200) * 2.50;
                }else if(kW >= 1201 && kW <= 2100){
                    payment += (kW - 1200) * 2.50;
                }

                if(kW >= 2101){
                    payment += (kW - 2100) * 3.00;
                }
                
                break;
            
            case 2:
                System.out.println("Negocio");
                payment = kW * 5;
                break;

            default: break;
        }

        System.out.println("Pago: $" + payment);
    }
}