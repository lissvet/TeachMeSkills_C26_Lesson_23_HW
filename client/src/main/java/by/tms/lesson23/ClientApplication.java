package by.tms.lesson23;

import by.tms.lesson23.console.ConsoleApplication;
import com.google.gson.Gson;
import by.tms.lesson23.model.Operation;
import by.tms.lesson23.storage.InMemory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ClientApplication {

	public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {

		Gson gson = new Gson();
		ConsoleApplication consoleApplication = new ConsoleApplication();
		InMemory memory = new InMemory();

		while (consoleApplication.checkDoOperation()){
			Operation operation = consoleApplication.createOperation();
			String json = gson.toJson(operation);

			HttpRequest request = HttpRequest.newBuilder()
					.uri(new URI("http://localhost:8080/calc"))
					.headers("Content-Type", "application/json")
					.POST(HttpRequest.BodyPublishers.ofString(json))
					.build();

			HttpClient httpClient = HttpClient.newHttpClient();
			HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

			Operation operation1 = gson.fromJson(response.body(), Operation.class);
			memory.addOperation(operation1);
			System.out.println(operation1);//for checking

//			if(consoleApplication.checkShowHistory()){
//				String jsonAllOperation = gson.toJson(memory.returnAllOperation());
//				HttpRequest requestAllOperation = HttpRequest.newBuilder()
//						.uri(new URI("http://localhost:8080/calc"))
//						.headers("Content-Type", "application/json")
//						.POST(HttpRequest.BodyPublishers.ofString(jsonAllOperation))
//						.build();
//
//				HttpClient httpClientAllOperation = HttpClient.newHttpClient();
//				HttpResponse<String> responseAllOperation = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
//				System.out.println();//for checking
//			}
		}
	}

}
