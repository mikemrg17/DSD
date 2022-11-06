import java.io.File;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.StringTokenizer;

public class Corrector {

	public static ArrayList<String> palabras = new ArrayList<String>();
	static final int MAX_THREADS = 5;

	public static void main(String args[]) throws IOException {

		try {
			
			File carpeta = new File("LIBROS_TXT");
			File[] libros = carpeta.listFiles();

			ExecutorService threadPool = Executors.newFixedThreadPool(MAX_THREADS);

			for (File libro : libros) {
				//Runnable proceso = new Proceso(libro.getAbsolutePath());
				Runnable proceso = new Proceso(libro);
				threadPool.execute(proceso);
			}
			threadPool.shutdown();

			try {
				threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
		    } catch (InterruptedException ex) {
		        threadPool.shutdownNow();
		        Thread.currentThread().interrupt();
		    }

		    System.out.println("Diccionario:");
		    for(String palabra: palabras)
		    	System.out.println(palabra);

		    Scanner input = new Scanner(System.in);
		    String texto_usuario;
			String[] palabras_usuario;

			System.out.println("\nInserte una cadena a evaluar");
			texto_usuario = input.nextLine();
			palabras_usuario = texto_usuario.split("\\s");

			System.out.println("Palabras erróneas: ");
			for(int i = 0; i < palabras_usuario.length; i++)
				if(!palabras.contains(palabras_usuario[i].toLowerCase()))
					System.out.println(palabras_usuario[i]);
		}catch(Exception ex) {
			ex.printStackTrace();
		}

	}
}

class Proceso implements Runnable {
	File libro;

	public Proceso(File libro) {
		this.libro = libro;
	}

	public void run(){
		try {
      		Scanner lector = new Scanner(libro);

      		System.out.println("Leyendo libro...");
      		String data = "";
      		while (lector.hasNextLine()) {
        		data += lector.nextLine();
      		}
      		System.out.println("Libro leido");

      		StringTokenizer st = new StringTokenizer(data);
      		String palabra = "";
      		while(st.hasMoreTokens())
      			palabra = st.nextToken();
				if(!Corrector.palabras.contains(palabra))
					Corrector.palabras.add(palabra.toLowerCase());

			System.out.println("Palabras capturadas");
      		
      		lector.close();
    	} catch (FileNotFoundException e) {
      		System.out.println("An error occurred.");
    		e.printStackTrace();
		}
	}
}
