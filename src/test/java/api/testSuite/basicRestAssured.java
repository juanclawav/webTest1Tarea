package api.testSuite;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class basicRestAssured {
    @Test
    public void createProjectByApi(){
        given()
                .auth()
                .preemptive()
                .basic("upbapi@upbapi.com","12345")
                .body("{\n"+
                        "\"Content\":\"WAAAA API\",\n"+
                        " \"Icon\":2\n"+
                        "}\n");
        when()
                .post("https://todo.ly/api/projects.json")
                .then()
                .log()
                .all()
                .statusCode(200)
                .body("Content",equalTo("WAAAA API"))
                .body("Icon",equalTo(2));
    }


}
