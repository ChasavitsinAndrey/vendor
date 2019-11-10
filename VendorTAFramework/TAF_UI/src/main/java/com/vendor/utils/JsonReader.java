package com.vendor.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JsonReader {

    private static Gson gson = new GsonBuilder().create();

    public static <T> T readJSONAsEntity(Class<T> responseType, String relativePath) {
        T entity = null;
        try {
            entity = gson.fromJson(new BufferedReader(new FileReader(relativePath)), responseType);
            return entity;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return entity;
    }

    public static String readJsonAsString(String relativePath) {
        try {
            String innerJson = (new BufferedReader(new FileReader(relativePath))).lines().collect(Collectors.joining());
            return innerJson;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List fillArrayListWithJsonArray(String jsonPath, String jsonNode) {
        String arString = Converter.unwrapString(JsonReader.readJsonAsString(jsonPath), jsonNode);
        JSONArray jsonArray = new JSONArray(arString);
        List<String> listFromJson = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            listFromJson.add(jsonArray.getString(i));
        }
        return listFromJson;
    }
}
