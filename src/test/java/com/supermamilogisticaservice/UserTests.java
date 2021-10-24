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
    void EnsureUsersAPIRequestWorks() throws Exception {
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/api/logistica-service/users")).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        assertThat(response.statusCode()).isEqualTo(200);
    }
    @Test
    void ensureUpdateUserAPIRequestWorks() throws Exception{

        JSONObject jObject = new JSONObject();
        jObject.put("first_name", "Test");
        jObject.put("last_name", "Testerino");
        jObject.put("password", "drowssap");
        jObject.put("username", "Testy");
        jObject.put("dni", "44444444");
        jObject.put("id_area", new Integer(1));

        String jsonBodyPOST = jObject.toJSONString();

        HttpClient client = HttpClient.newBuilder().build();

        HttpRequest requestPOST = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/api/logistica-service/user"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBodyPOST))
                .build();
        HttpResponse<String> responsePOST = client.send(requestPOST, HttpResponse.BodyHandlers.ofString());
        String bodyResponsePOST = responsePOST.body();
        System.out.println(bodyResponsePOST);


        JSONObject jsonObjectPUT = new JSONObject();


        jsonObjectPUT.put("id", new Integer(1));
        jsonObjectPUT.put("first_name", "David");
        jsonObjectPUT.put("last_name", "Testerino");
        jsonObjectPUT.put("password", "drowssap");
        jsonObjectPUT.put("phone_number", null);
        jsonObjectPUT.put("email", null);
        jsonObjectPUT.put("address", null);
        jsonObjectPUT.put("office", null);
        jsonObjectPUT.put("area", null);
        jsonObjectPUT.put("rol", null);
        jsonObjectPUT.put("active", new Boolean((true)));
        jsonObjectPUT.put("username", "Testy");
        jsonObjectPUT.put("dni", "44444444");

        String jsonBodyPUT = jsonObjectPUT.toJSONString();

        HttpRequest requestPUT = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/api/logistica-service/user/1"))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(jsonBodyPUT))
                .build();
        HttpResponse<String> responsePUT = client.send(requestPUT, HttpResponse.BodyHandlers.ofString());
        String bodyResponsePUT = responsePUT.body();
        System.out.println(bodyResponsePUT);
        assertTrue(bodyResponsePUT.contains("first_name\":\"David\""));
    }
    @Test
    void EnsureUserAPIRequestWorks() throws Exception {
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
    void EnsureUsersAPIRequestWorksJSON() throws Exception {
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
        assertTrue(body.contains("first_name\":\"Test\""));
    }
}
