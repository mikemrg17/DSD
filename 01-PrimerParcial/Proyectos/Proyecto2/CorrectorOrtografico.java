import java.io.File;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CorrectorOrtografico {

	public static ArrayList<String> diccionario = new ArrayList<String>();

	public static void main(String args[]) {
		File carpeta = new File("./LIBROS_TXT");
		File[] libros = carpeta.listFiles();
		
		for (File libro : libros) {
			analizarLibro(libro);
		}

		System.out.println("Diccionario:");
		for(String palabra: diccionario)
			System.out.println(palabra);

		Scanner input = new Scanner(System.in);
		String texto_usuario;
		String[] palabras_usuario;

		System.out.println("\nInserte una cadena a evaluar");
		texto_usuario = input.nextLine();
		palabras_usuario = texto_usuario.split("\\s");

		System.out.println("Palabras erróneas: ");
		for(int i = 0; i < palabras_usuario.length; i++)
			if(!diccionario.contains(palabras_usuario[i].toLowerCase()))
				System.out.println(palabras_usuario[i]);
	}

	static void analizarLibro(File libro) {
		try {
			BufferedReader lector = new BufferedReader(new FileReader("LIBROS_TXT/" + libro.getName()));
			System.out.println("Leyendo libro...");
      		String libro_texto = "";
      		String palabra;

      		while ((libro_texto = lector.readLine()) != null) {
      			StringTokenizer st = new StringTokenizer(libro_texto, ", ");
	      		while(st.hasMoreTokens()){
	      			palabra = st.nextToken();
					if(!diccionario.contains(palabra)){
						diccionario.add(palabra.toLowerCase());
					}
				}
      		}

      		System.out.println("Libro leido");
      		System.out.println("Palabras capturadas");
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
