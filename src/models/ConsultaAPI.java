package models;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaAPI {
    public Money busquedaMoneda(String moneyType) {
        URI direction = URI.create("https://v6.exchangerate-api.com/v6/e288d35479f888a3cef9fa76/latest/" + moneyType);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direction)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Money.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontré la divisa");
        }
    }
}

