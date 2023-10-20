package web.testSuite.filaC;

import api.todolyApiTest.factoryRequest.FactoryRequest;
import api.utils.Configuration;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.hamcrest.Matchers.equalTo;

public class ej2 extends testBaseApi {
    // 2) 15% API Test > Crear 4 users y luego eliminar todos los 4 users - todo.ly
    private final Random rnd = new Random();
    @ParameterizedTest
    @CsvSource(
            {
                    "juanclaudio1@gmail.com, 12345",
                    "juanclaudio2@gmail.com, 23456",
                    "juanclaudio3@gmail.com, 345678",
                    "juanclaudio4@gmail.com, 456789",
            }
    )
    public void createDeleteUser(String email, String password) {
        createUser(email, password);
        deleteUser();
    }

    private void createUser(String email, String password) {
        Configuration.user = email;
        Configuration.password = password;

        JSONObject body = new JSONObject();
        body.put("Email", email);
        body.put("Password", password);
        body.put("FullName", "Enrique");

        requestInfo.setUrl(Configuration.host + "/api/user.json")
                .setBody(body.toString());

        response = FactoryRequest.make(post).send(requestInfo);

        response.then().statusCode(200)
                .body("Email", equalTo(body.get("Email")))
                .body("FullName", equalTo(body.get("FullName")));
    }

    private void deleteUser() {
        requestInfo.setUrl(Configuration.host + "/api/user/0.json")
                .setBasicAuthNeeded(true);
        response = FactoryRequest.make(delete).send(requestInfo);
        response.then()
                .statusCode(200)
                .body("Email", equalTo(Configuration.user));
    }
}