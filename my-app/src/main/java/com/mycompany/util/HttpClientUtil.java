package com.mycompany.util;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.mycompany.config.*;


public class HttpClientUtil{
    public static HttpResponse<String> fetchData(String args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(ApiConfig.BASE_URL+"latest/"+args))
            .build();

        HttpResponse<String> response = client
            .send(request, BodyHandlers.ofString());

        return response;
    }
    public static HttpResponse<String> fetchPairData(String currency01, String currency02) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(ApiConfig.BASE_URL+"pair/" + currency01 + "/" + currency02))
            .build();

        HttpResponse<String> response = client
            .send(request, BodyHandlers.ofString());

        return response;
    }
}