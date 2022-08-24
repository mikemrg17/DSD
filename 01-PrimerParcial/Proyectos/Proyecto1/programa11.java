public class programa11 {
    public static void main(String[] args) {
        
        int number = 0, sumDigits = 0, digit = 0;
        String sNumber = "";
        String sDigits = "";
        String[] arrayDigits;

        for(number = 0; number <= 5000; number++){
            sNumber = String.valueOf(number);
            arrayDigits = sNumber.split("");
            for(int i = 0; i < arrayDigits.length; i++){
                digit = Integer.parseInt(arrayDigits[i]);
                sumDigits += (int)Math.pow(digit, 3);
                sDigits += arrayDigits[i] + "^3";
                if(i != arrayDigits.length - 1)
                    sDigits += " + ";
            }
            if(sumDigits == number){
                System.out.printf(number + " = ");
                System.out.printf(sDigits);
                System.out.printf("\n");
            }

            sDigits = "";
            sumDigits = 0;
        }
    }
}