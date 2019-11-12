package com.vendor.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class Converter {

    private static Gson gson = new GsonBuilder().create();

    public static <T> List<T> convertInnerJSONToList(Class<T> marker, String innerJson) {
        return gson.fromJson(innerJson, new CustomList<>(marker));
    }

    static class CustomList<X> implements ParameterizedType {

        private Class<?> wrapped;

        public CustomList(Class<X> wrapped) {
            this.wrapped = wrapped;
        }

        @Override
        public Type[] getActualTypeArguments() {
            return new Type[]{wrapped};
        }

        @Override
        public Type getRawType() {
            return List.class;
        }

        @Override
        public Type getOwnerType() {
            return null;
        }

    }

    public static <T> T convertJSONStringToEntity(Class<T> responseType, String innerJson) {
        return gson.fromJson(innerJson, responseType);
    }

    private static <T> T getFromJSONString(Class<T> clazz, String jsonString) {
        return gson.fromJson(jsonString, clazz);
    }

    private static <T> String convertToJSON(T clazz) {
        return gson.toJson(clazz);
    }

    public static <T> T getFromJSON(Class<T> clazz, String resp) {
        return gson.fromJson(resp, clazz);
    }

    public static String unwrapString(String jsonString, String toCut) {
        Map<String, Object> convertedObjects = getFromJSONString(Map.class, jsonString);
        String innerJson = convertToJSON(convertedObjects.get(toCut));
        return innerJson;
    }

    public static JsonElement convertToJsonElement(String str) {
        return gson.fromJson(str, JsonElement.class);
    }

}
