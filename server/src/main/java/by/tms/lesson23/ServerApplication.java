package by.tms.lesson23;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;


public class ServerApplication {
	public static void main(String[] args) throws IOException {
		HttpServer httpServer =
				HttpServer.create(new InetSocketAddress("localhost", 8080), 1);
		httpServer.createContext("/calc", new CalculatorHttpHandler());
		httpServer.start();
	}
}
