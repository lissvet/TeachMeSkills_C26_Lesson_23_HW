package by.tms.lesson23;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import by.tms.lesson23.model.Operation;
import by.tms.lesson23.service.OperationService;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

public class CalculatorHttpHandler implements HttpHandler {

	private final OperationService service = new OperationService();
	private final Gson gson = new Gson();

	@Override
	public void handle(HttpExchange exchange) throws IOException {

		InputStream requestBody = exchange.getRequestBody();
		byte[] bytes = requestBody.readAllBytes();

		StringBuilder s = new StringBuilder();

		for (byte aByte : bytes) {
			char aByte1 = (char) aByte;
			s.append(aByte1);
		}

		Operation operation = gson.fromJson(s.toString(), Operation.class);

		Operation calculate = service.calculate(operation);

		String json = gson.toJson(calculate);

		exchange.sendResponseHeaders(200, json.length());
		exchange.getResponseHeaders().add("Content-Type", "application/json");

		PrintWriter printWriter = new PrintWriter(exchange.getResponseBody());
		printWriter.print(json);
		printWriter.flush();
	}
}
