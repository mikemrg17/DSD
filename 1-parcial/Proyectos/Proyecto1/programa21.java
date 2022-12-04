import java.util.Scanner;

public class programa21 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int matrix[][] = new int[5][5];

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++) {
                System.out.println("Inserte el elemento [" + i + "][" + j + "]");
                matrix[i][j] = input.nextInt();
            }
        }

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++) {
                System.out.printf("[" + matrix[i][j] + "]");
            }
            System.out.printf("\n");
        }

        int mainDiagonal = 0;
        for(int i = 0; i < 5; i++){
            mainDiagonal += matrix[i][i];
        }

        System.out.println("Diagonal: " + mainDiagonal);
    }
}