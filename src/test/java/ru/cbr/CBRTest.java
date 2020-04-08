package ru.cbr;

import org.junit.Test;
import ru.TestBase;
import ru.endpoints.CBREndPoints;

import static org.hamcrest.core.IsEqual.equalTo;

public class CBRTest extends TestBase {

    public CBRTest() {
        super("cbr_api.uri");
    }

    @Test
    public void getCBRCoursesTest() {
        getWith200Status(CBREndPoints.DAILY_COURSE)
                .and()
                .body("Valute.USD.ID", equalTo("R01235"));
    }

}
