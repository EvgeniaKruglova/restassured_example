package ru.endpoints;

public interface LotrEndpoint {

    String BOOKs = "/book";
    String BOOK = "/book/{{id}}";
    String MOVIES = "/movie";
    String MOVIE = "/movie/{{id}}";
    String MOVIE_QUOTE = "/movie/{{id}}/quote";
    String CHARACTERS = "/character";
    String CHARACTER = "/character/{{id}}";
    String CHARACTER_QUOTE = "/character/{{id}}/quote";
    String QUOTES = "/quote";
    String CHAPTERS = "/chapter";
    String CHAPTER = "/chapter/{id}";

}
