package ru;

import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import lombok.SneakyThrows;
import org.apache.http.HttpStatus;

import java.util.Properties;

import static com.github.fge.jsonschema.SchemaVersion.DRAFTV4;

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

    protected ValidatableResponse getWith200Status(String endPoint) {
        return requestSpecification
                .get(endPoint)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

}
