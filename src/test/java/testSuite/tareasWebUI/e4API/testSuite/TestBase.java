package testSuite.tareasWebUI.e4API.testSuite;

import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import testSuite.tareasWebUI.e4API.factoryRequest.RequestInfo;

public class TestBase {
    public String post ="post";
    public String put = "put";
    public static String get ="get";
    public String delete ="delete";

    public static RequestInfo requestInfo;
    public static Response response;

    @BeforeEach
    public void before(){
        requestInfo = new RequestInfo();
    }
}