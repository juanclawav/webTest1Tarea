package api.todolyApiTest.factoryRequest;

import api.utils.Configuration;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class RequestPOST implements IRequest {
    @Override
    public Response send(RequestInfo requestInfo) {
        RequestSpecification req = given()
                .headers(requestInfo.getHeaders());

        if (requestInfo.isBasicAuthNeeded()){
            req.auth()
                    .preemptive()
                    .basic(Configuration.user, Configuration.password);
        }

        Response response = req
                .body(requestInfo.getBody())
                .log()
                .all().
                when()
                .post(requestInfo.getUrl());
        response.then().log().all();
        return response;
    }
}