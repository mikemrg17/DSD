import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class programa19 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int array[] = new int[10];

        for(int i = 0; i < 10; i++){
            System.out.println("Inserta un número:");
            array[i] = input.nextInt();
        }

        int aux1, aux2;
        aux1 = array[0];
        aux2 = 0;

        for(int i = 0; i < 10; i++){
            if(i < 9){
                if(i%2 == 0) {
                    aux2 = array[i+1];
                    array[i+1] = aux1;
                }else{
                    aux1 = array[i+1];
                    array[i+1] = aux2;
                }
            }else{
                array[0] = aux2;
                array[i] = aux1;
            }
        }

        for(int i = 0; i < 10; i++){
            System.out.printf("["+ array[i] + "] ");
        }
        System.out.printf("\n");


        
    }
}