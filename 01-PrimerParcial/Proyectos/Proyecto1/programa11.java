public class programa11 {
    public static void main(String[] args) {
        
        int a, b, c;
        int sum;
        int sumAux;
        String digits;

        for(sum = 0; sum <= 5000; sum++){
            String[] sSum = (String.valueOf(sum)).split();
            System.out.printf(sSum + " = ");
            for(int i = 0; i < sSum.length; i++){
                sumAux += (int)Math.pow(Integer.parseInt(sSum[i]), 3);
                digits += sSum[i] + "^3 + ";
            }
            if(sumAux == sum){
                System.out.printf(digits);
            }else{
                System.out.printf("no se encontró");
            }

            digits = "";
            sumAux = 0;

            /*if(sum < 10){
                if(sum == Math.pow(Integer.parseInt(sSum[1]),3)){
                    System.out.println(sSum + " = " + sSum[1] + "^3");
                }
            }else if(sum >= 10 && sum < 100){
                if(sum == Math.pow(sSum[1],3) + Math.pow(sSum[2],3)){
                    System.out.println(sSum + " = " + sSum[1] + "^3 + " + sSum[2] + "^3");
                }
            }else if(sum >= 100 && sum < 1000){
                
            }else{

            }*/
        }
    }
}