package ru.cbr;

import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import ru.endpoints.CBREndPoints;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import ru.TestBase;

import static com.github.fge.jsonschema.SchemaVersion.DRAFTV4;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.core.IsEqual.equalTo;

public class CBRTest extends TestBase {

    private JsonSchemaFactory jsonSchemaFactory;

    public CBRTest() {
        super("cbr_api.uri");
    }

    @Before
    public void setUp() {
        jsonSchemaFactory = JsonSchemaFactory
                .newBuilder()
                .setValidationConfiguration(ValidationConfiguration
                        .newBuilder()
                        .setDefaultVersion(DRAFTV4)
                        .freeze())
                .freeze();
    }

    @Test
    public void getCBRCoursesTest() {
        getWith200Status(CBREndPoints.DAILY_COURSE)
                .assertThat()
                .body(matchesJsonSchemaInClasspath("daily_course_schema.json").using(jsonSchemaFactory))
                .and()
                .body("Valute.USD.ID", equalTo("R01235"));
    }

}
