import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import com.alura.modelos.MonedaConversion;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;

public class ConsultaMoneda {
	
	private final String apiKey = "xxxxxxxx"; // ingrese su api key aquí

	public void consultar(String origen, String destino, double cantidad) {
		
		
		URI url = URI.create(String.format("https://v6.exchangerate-api.com/v6/%s/pair/%s/%s/%s", apiKey, origen, destino, cantidad));
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
		         .uri(url)
		         .build();
		
		try {
			HttpResponse<String> response = client
				     .send(request, BodyHandlers.ofString());
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			MonedaConversion moneda = gson.fromJson(response.body(), MonedaConversion.class);
			System.out.println(cantidad);
			System.out.println(String.format("%.2f %s -->> %.2f %s", cantidad, origen, moneda.conversion_result(), destino));
		} catch (IOException | InterruptedException e) {
			System.out.println("Se produjo un error");
		} 
	}
}
