package ru.models.lotr;

import lombok.Value;

import java.util.List;

@Value
public class BaseResponse<T> {

    List<T> docs;
    Integer total;

}
