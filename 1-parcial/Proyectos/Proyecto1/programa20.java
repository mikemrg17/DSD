public class programa20 {
    public static void main(String[] args) {
        int array[] = new int[10];
        int max;
        int min;

        for(int i = 0; i < 10; i++){
            array[i] = (int)(Math.random() * 10) + 1;
        }

        max = array[0];
        min = array[0];

        for(int i = 0; i < 10; i++) {
            if(array[i] > max) {
                max = array[i];
            }else if(array[i] < min){
                min = array[i];
            }
            System.out.printf("[" + array[i] + "]");
        }
        System.out.printf("\n");
        System.out.println("MAX: " + max);
        System.out.println("MIN: " + min);


    }
}