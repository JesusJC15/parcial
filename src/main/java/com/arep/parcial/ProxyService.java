package com.arep.parcial;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ProxyService {

    private String backendServiceUrl;

    public ProxyService() {
        String host = System.getenv("BACKEND_SERVICE_HOST");
        String port = "8080";
        if (host == null || port == null) {
            throw new IllegalStateException(
                    "Environment variables BACKEND_SERVICE_HOST and BACKEND_SERVICE_PORT must be set.");
        }
        this.backendServiceUrl = "http://" + host + ":" + port;
    }

    public String delegateRequest(String endpoint) throws IOException {
        URL url = new URL(backendServiceUrl + endpoint);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == 200) {
            try (Scanner scanner = new Scanner(connection.getInputStream())) {
                scanner.useDelimiter("\\A");
                return scanner.hasNext() ? scanner.next() : "";
            }
        } else {
            throw new IOException("Failed to fetch data from backend service. HTTP response code: " + responseCode);
        }
    }
}
