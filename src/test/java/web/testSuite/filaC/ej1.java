package web.testSuite.filaC;


import api.utils.Configuration;
import api.todolyApiTest.factoryRequest.FactoryRequest;
import web.testSuite.filaC.testBaseApi;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.hamcrest.Matchers.equalTo;

public class ej1 extends testBaseApi{
    private final Random rnd = new Random();

    @Test
    public void testing() {
        createUser();
        authenticate();
        createItem();
        deleteToken();
        createItemWithoutToken();
    }

    private void createUser() {
        String randomEmail = "juanito" + rnd.nextInt() + "@gmail.com";
        String randomPassword = "pwd" + rnd.nextInt();

        Configuration.user = randomEmail;
        Configuration.password = randomPassword;

        JSONObject body = new JSONObject();
        body.put("Email", randomEmail);
        body.put("Password", randomPassword);
        body.put("FullName", "JuanClaudio");

        requestInfo.setUrl(Configuration.host + "/api/user.json")
                .setBody(body.toString());

        response = FactoryRequest.make(post).send(requestInfo);

        response.then().statusCode(200)
                .body("Email", equalTo(body.get("Email")))
                .body("FullName", equalTo(body.get("FullName")));
    }

    private void createItem() {
        String randomContent = "Item " + rnd.nextInt();

        JSONObject body = new JSONObject();
        body.put("Content", randomContent);

        requestInfo.setUrl(Configuration.host + "/api/items.json")
                .setBody(body.toString());
        response = FactoryRequest.make(post).send(requestInfo);
        response.then().statusCode(200).
                body("Content", equalTo(body.get("Content")));
    }

    private void deleteToken() {
        requestInfo.setUrl(Configuration.host + "/api/authentication/token.json");
        response = FactoryRequest.make(delete).send(requestInfo);
        response.then()
                .statusCode(200)
                .body("UserEmail", equalTo(Configuration.user))
                .body("TokenString", equalTo(requestInfo.getHeaders().get("Token")));
    }

    private void createItemWithoutToken() {
        String randomContent = "Item " + rnd.nextInt();

        JSONObject body = new JSONObject();
        body.put("Content", randomContent);

        requestInfo.setUrl(Configuration.host + "/api/items.json")
                .setBody(body.toString());
        response = FactoryRequest.make(post).send(requestInfo);
        response.then().statusCode(200).
                body("ErrorMessage", equalTo("Not Authenticated"))
                .body("ErrorCode", equalTo(102));
    }
}