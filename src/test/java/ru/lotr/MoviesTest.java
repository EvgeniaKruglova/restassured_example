package ru.lotr;

import com.google.gson.reflect.TypeToken;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import ru.endpoints.LotrEndpoints;
import ru.models.lotr.BaseResponse;
import ru.models.lotr.movies.Movie;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MoviesTest extends LotrTest {

    String errMsg = "Количество фильмов не совпадает с ожидаемым.\n Ожидалось 3 фильма.\nСписок вернувшихся фильмов:\n%s";
    ThreadLocal<ValidatableResponse> threadResponse = new ThreadLocal<>();

    public MoviesTest() {
        super();
        String authToken = props.getProperty("auth_token");
        requestSpecification.header("Authorization", authToken);
    }

    @Test
    @DisplayName("Тест количества снятых фильмов")
    public void testMovies() {
        ValidatableResponse response = getWith200Status(LotrEndpoints.MOVIES);
        threadResponse.set(response);
        assertFilmsNumber();
    }

    @Step("Количество снятых фильмов = 3")
    public void assertFilmsNumber() {
        ValidatableResponse moviesResponse = threadResponse.get();
        String json = getJsonResponseBody(moviesResponse);
        BaseResponse<Movie> response = gson.fromJson(json, new TypeToken<BaseResponse<Movie>>(){}.getType());
        List<Movie> resultMovies = response.getDocs();

        assertThat(resultMovies)
                .withFailMessage(String.format(errMsg, resultMovies))
                .hasSize(3);
    }

}
