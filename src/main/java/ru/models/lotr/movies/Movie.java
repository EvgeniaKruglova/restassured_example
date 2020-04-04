package ru.models.lotr.movies;

import com.google.gson.annotations.SerializedName;
import lombok.Value;

@Value
public class Movie {

    @SerializedName("_id")
    String id;
    Integer budgetInMillions;
    String name;
    Double boxOfficeRevenueInMillions;
    Integer academyAwardNominations;
    Integer academyAwardWins;

}
