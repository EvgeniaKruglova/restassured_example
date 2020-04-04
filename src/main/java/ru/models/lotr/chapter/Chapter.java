package ru.models.lotr.chapter;

import com.google.gson.annotations.SerializedName;
import lombok.Value;

@Value
public class Chapter {

    @SerializedName("_id")
    String id;

    String name;

}


