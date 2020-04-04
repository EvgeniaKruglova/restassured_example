package ru.models.lotr;

import lombok.Value;

@Value
public class Pages {

    Integer current;
    Integer prev;
    Boolean hasPrev;
    Integer next;
    Boolean hasNext;
    Integer total;

}
