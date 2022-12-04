import java.util.Scanner;

public class programa22 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int matrixA[][];
        int matrixB[][];
        int matrixC[][];

        int iA, jA, jB;
        System.out.println("Filas de matrix A: ");
        iA = input.nextInt();

        System.out.println("Columas de matriz A y filas de matriz B: ");
        jA = input.nextInt();
        matrixA = new int[iA][jA];

        System.out.println("Columnas de matriz B: ");
        jB = input.nextInt();
        matrixB = new int[jA][jB];

        matrixC = new int[iA][jB];

        for(int i = 0; i < iA; i++){
            for(int j = 0; j < jA; j++){
                System.out.println("Matriz A: [" + i + "][" + j + "]");
                matrixA[i][j] = input.nextInt();
            }
        }

        for(int i = 0; i < jA; i++){
            for(int j = 0; j < jB; j++){
                System.out.println("Matriz B: [" + i + "][" + j + "]");
                matrixB[i][j] = input.nextInt();
            }
        }

        System.out.printf("\n");
        System.out.println("-------Matriz A-------");
        System.out.printf("\n");

        for(int i = 0; i < iA; i++){
            for(int j = 0; j < jA; j++) {
                System.out.printf("[" + matrixA[i][j] + "]");
            }
            System.out.printf("\n");
        }

        System.out.printf("\n");
        System.out.println("-------Matriz B-------");
        System.out.printf("\n");

        for(int i = 0; i < jA; i++){
            for(int j = 0; j < jB; j++) {
                System.out.printf("[" + matrixB[i][j] + "]");
            }
            System.out.printf("\n");
        }

        System.out.printf("\n");
        System.out.println("-------Multiplicación de A y B-------");
        System.out.printf("\n");

        for(int i = 0; i < iA; i++){
            for(int j = 0; j < jB; j++){
                for(int k = 0; k < jA; k++){
                    matrixC[i][j] += matrixA[i][k] * matrixB[k][j];    
                }
            }
        }

        for(int i = 0; i < iA; i++){
            for(int j = 0; j < jB; j++) {
                System.out.printf("[" + matrixC[i][j] + "]");
            }
            System.out.printf("\n");
        }

    }
}