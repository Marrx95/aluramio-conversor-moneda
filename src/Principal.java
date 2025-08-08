import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		int opcion = -1;
		double montoAConvertir;
		
		
		while(opcion != 7) {
			mostrarMenu();
			opcion = entrada.nextInt();
			if(opcion != 7) {
				System.out.println("Ingrese el monto a convertir: ");
				montoAConvertir = entrada.nextDouble();
				evaluarOpcion(opcion, montoAConvertir);
			} else {
				System.out.println("Programa finalizado.");
			}
		}
		
		
		entrada.close();

	}
	
	private static void mostrarMenu() {
		final String menu = """
				************************************************************
				Bienvenido al conversor de monedas :)
				
				1) Dólar -> Peso argentino
				2) Peso argentino -> Dólar
				3) Dólar -> Real brasileño
				4) Real brasileño -> dolar
				5) Dólar -> Peso mexicano
				6) Peso mexicano -> Dólar
				7) Salir
				
				************************************************************
				""";
		System.out.println(menu);
	}
	
	private static void evaluarOpcion(int opcion, double monto) {
		
		ConsultaMoneda consulta = new ConsultaMoneda();
		
		switch(opcion) {
			case 1: consulta.consultar("USD", "ARS", monto);
					break;
			case 2: consulta.consultar("ARS", "USD", monto);
					break;
			case 3: consulta.consultar("USD", "BRL", monto);
					break;
			case 4: consulta.consultar("BRL", "USD", monto);
					break;
			case 5: consulta.consultar("USD", "MXN", monto);
					break;
			case 6: consulta.consultar("MXN", "USD", monto);
					break;
			default: System.out.println("Opción no válida");
			
		}
	}

}
