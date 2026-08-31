package com.example;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.time.LocalDateTime;

public class App {

    public static void main(String[] args) throws IOException {
        int port = 8081;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

        server.createContext("/", App::handleRequest);
        server.setExecutor(null);
        server.start();

        System.out.println("Aplicativo iniciado. Escuchando en el puerto " + port);
    }

    private static void handleRequest(HttpExchange exchange) throws IOException {
        String hostname = System.getenv().getOrDefault("HOSTNAME", "desconocido");
        String response = "Hola desde el contenedor de la aplicacion - holaprofe" +
                "Host: " + hostname + "\n" +
                "Fecha/Hora: " + LocalDateTime.now() + "\n";

        exchange.sendResponseHeaders(200, response.getBytes().length);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(response.getBytes());
        }
    }
}
