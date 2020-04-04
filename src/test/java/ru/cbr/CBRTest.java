package ru.cbr;

import com.github.fge.jsonschema.main.JsonSchemaFactory;
import org.junit.Before;
import org.junit.Test;
import ru.TestBase;
import ru.endpoints.CBREndPoints;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.core.IsEqual.equalTo;

public class CBRTest extends TestBase {

    private JsonSchemaFactory jsonSchemaFactory;

    public CBRTest() {
        super("cbr_api.uri");
    }

    @Before
    public void setUp() {
        jsonSchemaFactory = createSchemaFactory();
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
