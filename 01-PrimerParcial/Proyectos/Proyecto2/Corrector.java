import java.io.File;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Corrector {

	public static ArrayList<String> palabras = new ArrayList<String>();
	static final int MAX_THREADS = 5;

	public static void main(String args[]) throws IOException {

		try {
			ExecutorService threadPool = Executors.newFixedThreadPool(MAX_THREADS);  
			final File carpeta = new File("./LIBROS_TXT");
			final ArrayList<File> libros = new ArrayList<File>(Arrays.asList(carpeta.listFiles()));
			Scanner input = new Scanner(System.in);

			String texto_usuario;
			String[] palabras_usuario;

			for(File libro: libros){
				Runnable proceso = new Proceso(libro.getAbsolutePath());
				threadPool.execute(proceso);
			}
			threadPool.shutdown();

			try {
				threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
		    } catch (InterruptedException ex) {
		        threadPool.shutdownNow();
		        Thread.currentThread().interrupt();
		    }

			System.out.println("Inserte una cadena a evaluar");
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
	String path;

	public Proceso(String path) {
		this.path = path;
	}

	public void run(){
		try(BufferedReader buffer = new BufferedReader(new FileReader(path))) {
			System.out.println("Leer libro");

			StringBuilder builder = new StringBuilder();
			String[] palabras_libro;

			String str;
			
			while((str = buffer.readLine()) != null) {
				builder.append(str).append("\n");
			}

			palabras_libro = builder.toString().trim().split("\\s+");

			for(int i = 0; i < palabras_libro.length; i++){
				if(!Corrector.palabras.contains(palabras_libro[i]))
					Corrector.palabras.add(palabras_libro[i].toLowerCase());
			}

			System.out.println("Palabras capturadas");

		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}
}
