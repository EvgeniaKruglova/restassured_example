package ru.models.lotr.books;

import com.google.gson.annotations.SerializedName;
import lombok.Value;

@Value
public class Book {

    @SerializedName("_id")
    String id;

    String name;

}
