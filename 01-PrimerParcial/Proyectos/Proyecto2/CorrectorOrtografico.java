/*
	Proyecto 2: Primera parte
	Alumno: Murga Dionicio Miguel Angel
	Grupo: 4CM14
*/

import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.HashSet;

public class CorrectorOrtografico {
	public static HashSet<String> diccionario = new HashSet<String>();

	public static void main(String args[]) {
		File carpeta = new File("./LIBROS_TXT");
		File[] libros = carpeta.listFiles();
		
		for (File libro : libros) {
			analizarLibro(libro);
		}

		Scanner input = new Scanner(System.in);
		String texto_usuario;
		String[] palabras_usuario;
		String opt = "";

		do {
			System.out.println("Inserte una cadena a evaluar");
			texto_usuario = input.nextLine();
			palabras_usuario = texto_usuario.split("\\s");

			System.out.println("Palabras erróneas: ");
			for(int i = 0; i < palabras_usuario.length; i++)
				if(!diccionario.contains(palabras_usuario[i]))
					System.out.println(palabras_usuario[i]);

			System.out.println("Otra cadena? Si: S | s");
			opt = input.nextLine();
		} while(opt.equals("S") || opt.equals("s")); 

		
	}

	static void analizarLibro(File libro) {
		try {
			BufferedReader lector = new BufferedReader(new FileReader("./LIBROS_TXT/" + libro.getName()));
      		String libro_texto = "";
      		String palabra;
      		StringTokenizer st;

      		while ((libro_texto = lector.readLine()) != null) {
      			st = new StringTokenizer(libro_texto, " ");
	      		while(st.hasMoreTokens()){
	      			palabra = st.nextToken();
					if(!diccionario.contains(palabra)){
						diccionario.add(palabra);
					}
				}
      		}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
