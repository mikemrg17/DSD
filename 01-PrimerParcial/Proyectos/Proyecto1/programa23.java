import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.util.ArrayList;


public class programa23 {

    public static String fileName = "programa23Data.txt";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        File file = new File(fileName);
        ArrayList<String> registers = new ArrayList<String>();

        int age, height;
        age = -1;
        height = -1;

        try{
            if(file.createNewFile()){
                System.out.println("Archivo creado");
            }else{
                System.out.println("El archivo ya existe");
            }

            FileWriter fileWriter = new FileWriter(fileName, true);

            while(age != 0){
                System.out.println("Introduce tu edad");
                age = input.nextInt();

                if(age == 0)
                    break;

                System.out.println("Introduce tu altura en cm");
                height = input.nextInt();

                registers.add("EDAD: " + age + ", ALTURA: " + height + "\n");
            }

            for(String register: registers) {
                fileWriter.write(register);
            }

            fileWriter.close();

        }catch(IOException e){
            System.out.println("Ocurrió un error");
            e.printStackTrace();
        }
    }
}