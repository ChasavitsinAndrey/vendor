package com.vendor.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Properties;

/**
 * Class is responsible for reading and providing data from Ws.config.properties file
 */

@Slf4j
public class PropertyReader {

    public static HashMap<String, String> readFromFile(String fileRelativePath) {
        HashMap<String, String> propertyMap = new HashMap<>();
        Properties properties = new Properties();
        InputStream inputStream;
        try {
            inputStream = new FileInputStream("..//" + fileRelativePath);
            properties.load(inputStream);
            for (String key : properties.stringPropertyNames()) {
                propertyMap.put(key, properties.get(key).toString());
            }
        } catch (FileNotFoundException e) {
            log.error("File " + fileRelativePath + " is not found");
        } catch (IOException e) {
            log.error("Input output error");
        }
        return propertyMap;
    }

    public static <T> void instanceCreator(String fileRelativePath, Class<T> tClass) {
        try {
            HashMap<String, String> propertyMap = readFromFile(fileRelativePath);
            Field[] fieldsFromClass = tClass.getDeclaredFields();
            Object instance = tClass.newInstance();
            for (Field field : fieldsFromClass) {
                if (!propertyMap.get(field.getName().toLowerCase()).isEmpty()) {
                    field.setAccessible(true);
                    field.set(instance, propertyMap.get(field.getName().toLowerCase()));
                }
            }
        }
        catch (IllegalAccessException e) {

        }
        catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
    private static void justMethod () {
        
    }
}



