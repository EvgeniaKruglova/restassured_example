package ru.lotr;

import com.google.gson.Gson;
import ru.TestBase;

public class LotrTest extends TestBase {

    protected final Gson gson;

    public LotrTest() {
        super("lotr_api.uri");
        gson = new Gson();
    }

}
