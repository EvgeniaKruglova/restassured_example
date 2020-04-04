package ru.lotr;

import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import ru.endpoints.LotrEndpoint;
import ru.models.lotr.BaseResponse;
import ru.models.lotr.movies.Movie;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MoviesTest extends LotrTest {

    public MoviesTest() {
        super();
        String authToken = props.getProperty("auth_token");
        requestSpecification.header("Authorization", authToken);
    }

    @Test
    public void testMovies() {
        String json = getWith200Status(LotrEndpoint.MOVIES).extract().response().getBody().prettyPrint();
        BaseResponse<Movie> response = gson.fromJson(json, new TypeToken<BaseResponse<Movie>>(){}.getType());
        List<Movie> resultMovies = response.getDocs();

        assertThat(resultMovies).hasSize(8);
    }

}
