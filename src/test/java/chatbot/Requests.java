package chatbot;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class Requests extends BaseClass {

    static String request(String environment, String fileName) throws IOException {
        String url = "";
        String cid= String.valueOf(UUID.randomUUID());
        String operation ="";
        String rightBody = new String(Files.readAllBytes(Paths.get(paths + fileName)), StandardCharsets.UTF_8);
        switch (environment) {
            case "stage":
                url = BaseClass.stageUrl;
                break;
            case "test":
                url = BaseClass.testUrl;
                break;
        }
        switch (fileName) {
            case "createAplication.json":
                operation = "create-application";
                break;
            case "updateApplication.json":
                operation = "update-application";
                break;
            case "getClaimAsynchron.json":
                operation = "get-claim-async";
                break;
            case "findPoint.json":
                operation = "find-point";
                break;
            case "changeServiceStation.json":
                operation = "change-service-station";
                break;
        }
        String finalUrl = url + operation;
        Response response = RestAssured.given().log().all()
                .header("X-VSK-CorrelationId", cid)
                .contentType(ContentType.JSON)
                .body(rightBody)
                .when()
                .post(finalUrl)
                .then()
                .statusCode(200)
                .extract()
                .response();
        String serviceResponse = response.body().asString();
        switch (fileName) {
            case "createAplication.json":
                assertThat(serviceResponse, containsString( "\"status\": 1"));
                assertThat(serviceResponse, containsString( "\"errors\": [\"\"]"));
                break;
            case "updateApplication.json":
            case "changeServiceStation.json":
                assertThat(serviceResponse, containsString( "status\":1"));
                break;
            case "getClaimAsynchron.json":
                assertThat(serviceResponse, containsString( "return\":3"));
                break;
            case "findPoint.json":
                assertThat(serviceResponse, containsString( "\"status\":0"));
                assertThat(serviceResponse, containsString( "\"UTUData\":"));
                break;
        }
        System.out.println(serviceResponse);
        return cid;
    }


}
