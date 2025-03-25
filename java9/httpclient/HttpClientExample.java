package java9.httpclient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class HttpClientExample {
    public static void main(String[] args) {
        System.out.println("🚀 Démonstration du nouveau HTTP Client en Java 9");

        // Création du client HTTP
        HttpClient client = HttpClient.newHttpClient();

        // Construction de la requête GET
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts/1"))
                .GET()
                .build();

        // Envoi asynchrone de la requête
        CompletableFuture<HttpResponse<String>> responseFuture =
                client.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        // Traitement de la réponse une fois reçue
        responseFuture.thenAccept(response -> {
            System.out.println("✅ Statut HTTP : " + response.statusCode());
            System.out.println("📥 Réponse : " + response.body());
        }).join(); // Attendre la fin du traitement
    }
}
