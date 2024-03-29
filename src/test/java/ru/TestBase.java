package ru;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import lombok.SneakyThrows;
import org.apache.http.HttpStatus;
import ru.endpoints.LotrEndpoints;

import java.util.Properties;

public class TestBase {

    public RequestSpecification requestSpecification;
    public Properties props;

    @SneakyThrows
    public TestBase(String baseURI) {
        props = new Properties();
        props.load(getClass()
                .getClassLoader()
                .getResourceAsStream("config.properties")
        );
        //Rest Assured config
        RestAssured.baseURI = props.getProperty(baseURI);
        //basic request setting
        requestSpecification = RestAssured.given().contentType(ContentType.JSON);
    }

    @Step("Запрос к {endPoint} выполнился с кодом 200")
    protected ValidatableResponse getWith200Status(String endPoint) {

        return requestSpecification
                .get(endPoint)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }

    @Attachment
    protected String getJsonResponseBody(ValidatableResponse response) {
        return response.extract().response().getBody().prettyPrint();
    }


}
