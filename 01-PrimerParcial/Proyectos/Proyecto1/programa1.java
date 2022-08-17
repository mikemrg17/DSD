public class programa1 {
	public static void main(String[] args) {
		int radio = 5; //Radio del círculo
		int altura = 10; //Altura

		double area_circulo = Math.PI * Math.pow(radio, 2);
	
		double volumen_cono = (area_circulo * altura)/3;
		System.out.println("Volúmen del cono: " + volumen_cono);
		double volumen_cilindro = area_circulo * altura;
		System.out.println("Volúmen del cilindro: " + volumen_cilindro);
		double diferencia_volumenes = volumen_cilindro - volumen_cono;
		System.out.println("Diferencia de volúmenes: " + diferencia_volumenes);
	}
}
