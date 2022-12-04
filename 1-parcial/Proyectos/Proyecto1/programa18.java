import java.util.Scanner;

public class programa18 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int array1[] = new int[10];
        int array2[] = new int[10];
        int result[] = new int[20];

        for(int i = 0; i < 20; i++) {
            if(i < 10) {
                System.out.println("Inserta elemento para el arreglo 1: ");
                array1[i] = input.nextInt();
            }else{
                System.out.println("Inserta elemento para el arreglo 2: ");
                array2[i-10] = input.nextInt();
            }
        }
        
        for(int i = 0; i < 10; i ++) {
            result[i*2] = array1[i];
            result[(i*2)+1] = array2[i];
        }

        for(int i = 0; i < 20; i++){
            System.out.printf("[" + result[i] + "] ");
        }
        System.out.printf("\n");

    }
}