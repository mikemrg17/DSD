public class programa12 {
    public static void main(String[] args) {
        double balance, utility;
        balance = 0;

        for(int i = 1; i <= 20; i++){
            if(i <= 10)
                balance += 500;

            utility = balance * 0.05;
            balance += utility;
        }

        System.out.format("%.2f\n", balance);
    }
}