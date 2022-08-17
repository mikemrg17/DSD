public class programa4 {
	public static void main(String[] args) {
		int a = 2, b = 10, c = 3;
		double x1, x2;

		if((4*a*c) > Math.pow(b,2)){
			System.out.println("No hay soluciones reales");
		}else{
			x1 = (0 - b - Math.sqrt(Math.pow(b,2) - 4*a*c)) / (2 * a);
			x2 = (0 - b + Math.sqrt(Math.pow(b,2) - 4*a*c)) / (2 * a);
			System.out.println("X1 = " + x1);
			System.out.println("X2 = " + x2);
		}
	}
}
