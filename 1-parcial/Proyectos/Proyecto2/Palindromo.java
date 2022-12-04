/*
	Proyecto 2: Parte 2
	Alumno: Murga Dionicio Miguel Angel
	Grupo: 4CM14
*/

import java.util.Scanner;
import java.util.HashSet;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Palindromo {

	static HashSet<String> palindromos = new HashSet<String>();

	public static void main(String[] args) {
		try {
			BufferedReader lector = new BufferedReader(new FileReader(args[0]));
      		String texto_archivo;
      		StringBuilder sb = new StringBuilder();

      		while ((texto_archivo = lector.readLine()) != null) {
      			sb.append(texto_archivo);
      			sb.append(System.getProperty("line.separator"));
      		}

      		lector.close();

      		texto_archivo = sb.toString();
      		texto_archivo = texto_archivo.replace("\n", " ");
			analizarTexto(texto_archivo.toLowerCase());

			System.out.println("------PALÍNDROMOS-----:");
			for(String palindromo: palindromos)
				System.out.println(palindromo);

		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static void analizarTexto(String texto) {
		String[] texto_dividido = texto.split(" ");
		HashSet<String> combinaciones = new HashSet<String>();

		String combinacion = "";
		for(int i = 0; i < texto_dividido.length; i++){
			combinacion = texto_dividido[i] + " ";
			combinaciones.add(combinacion);
			for(int j = i + 1; j < texto_dividido.length; j++){
				combinacion += texto_dividido[j] + " ";
				combinaciones.add(combinacion);
			}
		}

		long espacios = 0;

		for(String comb: combinaciones){
			espacios = comb.chars().filter(ch -> ch == ' ').count();
			if (espacios > 1) {
				esPalindromo(comb);	
			}
		}
	}

	public static void esPalindromo(String cadena) {
		String cadena_auxiliar = cadena.replaceAll(",", " ").replaceAll(" ", "").replaceAll("\n","");
		StringBuilder cadena_SB = new StringBuilder(cadena_auxiliar);
		if(cadena_auxiliar.equals(cadena_SB.reverse().toString())){
			if(!palindromos.contains(cadena) && cadena.contains(" "))
				palindromos.add(cadena);
		}
	}
}