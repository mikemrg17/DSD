import java.util.Scanner;

public class programa12 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double balance, utility;
        System.out.println("Indique la cantidad en dólares con la que comienza la inversión");
        balance = input.nextInt();

        for(int i = 1; i <= 20; i++){
            if(i <= 10)
                balance += 500;

            utility = balance * 0.05;
            balance += utility;
        }

        System.out.format("Dinero después de 20 años: %.2f\n", balance);
    }
}