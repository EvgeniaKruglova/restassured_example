package ru.models.lotr.quotes;

import com.google.gson.annotations.SerializedName;
import lombok.Value;

@Value
public class Quote {

    @SerializedName("_id")
    String id;

    String dialog;

    @SerializedName("movie")
    String movie_id;

    @SerializedName("character")
    String character_id;

}
