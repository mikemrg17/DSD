import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class programa24 {

    public static String fileName = "programa24Data.txt";

    public static void main(String[] args) {
        int max, lineCounter, lineSaver;
        max = 0;
        lineCounter = 1;
        lineSaver = 1;

        try{
            File file = new File(fileName);
            Scanner reader = new Scanner(file);

            while(reader.hasNextLine()){
                int number = reader.nextInt();
                lineCounter++;

                if(number > max){
                    max = number;
                    lineSaver = lineCounter - 1;
                }
                    

            }

            System.out.println("Max: " + max);
            System.out.println("Linea: " + lineSaver);

            reader.close();
        }catch(FileNotFoundException e){
            System.out.println("Ocurrió un error");
            e.printStackTrace();
        }
    }
}