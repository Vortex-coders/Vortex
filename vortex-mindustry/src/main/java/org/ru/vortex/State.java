package org.ru.vortex;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.ru.vortex.modules.Config;

import static com.google.gson.FieldNamingPolicy.LOWER_CASE_WITH_DASHES;

public class State
{
    public static final Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(LOWER_CASE_WITH_DASHES)
            .setPrettyPrinting()
            .serializeNulls()
            .disableHtmlEscaping()
            .create();
    public static Config config;
}
