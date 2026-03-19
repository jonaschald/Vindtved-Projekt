package com.example.vindtved_projekt;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class API
{
    private String URI = "https://vind-og-klima-app.videnomvind.dk/api/stats?location=vindtved";
    private HttpClient client;
    private HttpRequest request;

    public APILatestReading getLatestReading()
    {
        HttpResponse<String> response = requestData();
        JsonObject jObject = JsonParser.parseString(response.body()).getAsJsonObject();
        Gson gson = new Gson();

        return gson.fromJson(jObject.get("latest_reading"), APILatestReading.class);
    }

    public APIMathData getMathData()
    {
        HttpResponse<String> response = requestData();
        JsonObject jObject = JsonParser.parseString(response.body()).getAsJsonObject();
        Gson gson = new Gson();

        return gson.fromJson(jObject, APIMathData.class);
    }

    public APILatestReading[] getLatestReadingLastMonth()
    {
        HttpResponse<String> response = requestData();
        JsonObject jObject = JsonParser.parseString(response.body()).getAsJsonObject();
        Gson gson = new Gson();

        return gson.fromJson(jObject.get("last_month"), APILatestReading[].class);
    }

    private HttpResponse<String> requestData() {
        if (client == null)
            client = HttpClient.newBuilder().build();

        try {
            if (request == null)
                request = HttpRequest
                        .newBuilder()
                        .uri(new URI(URI))
                        .GET()
                        .build();
        } catch (URISyntaxException e) {
            System.out.println("URI er ikke valid");
            throw new RuntimeException(e);
        }

        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            System.out.println("Kunne ikke sende Http Request:");
            throw new RuntimeException(e);
        }
    }
}