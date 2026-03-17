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
import java.util.ArrayList;
import java.util.List;

public class API
{
    private String URI = "https://vind-og-klima-app.videnomvind.dk/api/stats?location=vindtved";

    public List getLatestReading() {
        HttpClient client = HttpClient.newBuilder().build();

        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(new URI(URI))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        JsonObject jObject = JsonParser.parseString(response.body()).getAsJsonObject();

        Gson gson = new Gson();
        APILatestReading latestReading = gson.fromJson(jObject.get("latest_reading"), APILatestReading.class);
        List<APILatestReading> latestReadings = gson.fromJson(jObject.get("latest_readings"), ArrayList.class);

        return latestReadings;
    }

    public List getLatestReadingLastMonth()
    {
        HttpClient client = HttpClient.newBuilder().build();

        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(new URI(URI))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        JsonObject jObject = JsonParser.parseString(response.body()).getAsJsonObject();

        Gson gson = new Gson();
        APILatestReading latestReadingLastMonth = gson.fromJson(jObject.get("last_month"), APILatestReading.class);
        List<APILatestReading> latestReadingsLastMonth = gson.fromJson(jObject.get("last_month"), ArrayList.class);

        return latestReadingsLastMonth;
    }
}