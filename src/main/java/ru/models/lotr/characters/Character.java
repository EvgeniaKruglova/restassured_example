package ru.models.lotr.characters;

import com.google.gson.annotations.SerializedName;
import lombok.Value;

@Value
public class Character {

    @SerializedName("_id")
    String id;

    String height;
    String race;
    String gender;
    String birth;
    String spouse;
    String death;
    String name;
    String realm;
    String hair;
    String wikiUrl;

}
