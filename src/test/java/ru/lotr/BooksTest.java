package ru.lotr;

import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import ru.endpoints.LotrEndpoint;
import ru.models.lotr.BaseResponse;
import ru.models.lotr.books.Book;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BooksTest extends LotrTest {

    @Test
    public void testBooks() {
        String json = getWith200Status(LotrEndpoint.BOOKS).extract().response().getBody().prettyPrint();
        BaseResponse<Book> response = gson.fromJson(json, new TypeToken<BaseResponse<Book>>(){}.getType());
        List<Book> resultBooks = response.getDocs();

        assertThat(resultBooks).containsExactly(
                new Book("5cf5805fb53e011a64671582", "The Fellowship Of The Ring"),
                new Book("5cf58077b53e011a64671583", "The Two Towers"),
                new Book("5cf58080b53e011a64671584", "The Return Of The King")
        );

    }

}
