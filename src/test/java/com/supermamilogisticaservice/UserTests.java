package com.supermamilogisticaservice;

import com.supermamilogisticaservice.models.User;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UserTests {
    @Test
    void aEnsureUsersAPIRequestWorks() throws Exception {
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/api/logistica-service/users")).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        assertThat(response.statusCode()).isEqualTo(200);
    }
    @Test
    void bEnsureUserAPIRequestWorks() throws Exception {
        User userToPost = new User();
        HttpClient client = HttpClient.newBuilder().build();

        JSONObject jObject = new JSONObject();

        jObject.put("first_name", "Lucas2");
        jObject.put("last_name", "GOrdillo");
        jObject.put("password", "1234521234");
        jObject.put("username", "lgordillo");
        jObject.put("dni", "4353535");
        jObject.put("id_area", new Integer(1));

        String jsonBody = jObject.toJSONString();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/api/logistica-service/user"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        assertThat(response.statusCode()).isEqualTo(200);
    }
    @Test
    void cEnsureUsersAPIRequestWorksJSON() throws Exception {
        User userToPost = new User();
        HttpClient client = HttpClient.newBuilder().build();

        JSONObject jObject = new JSONObject();

        jObject.put("first_name", "Test");
        jObject.put("last_name", "Testerino");
        jObject.put("password", "drowssap");
        jObject.put("username", "Testy");
        jObject.put("dni", "44444444");
        jObject.put("id_area", new Integer(1));

        String jsonBody = jObject.toJSONString();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/api/logistica-service/user"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();
        System.out.println(body);
        assertTrue(body.contains("last_name\":\"Testerino\""));
    }
}
