/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.namehistoryswing;


/**
 *
 * @author cait
 */
import okhttp3.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Map;

public class NameInfoClient {

    private static final String API_URL = "http://localhost:8080/get_name_info";
    private static final OkHttpClient client = new OkHttpClient();

    public static String getNameInfo(String name) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonPayload = objectMapper.writeValueAsString(Map.of("name", name));

        RequestBody body = RequestBody.create(
                jsonPayload,
                MediaType.parse("application/json")
        );
        Request request = new Request.Builder()
                .url(API_URL)
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            return response.body().string();
        }
    }
}

