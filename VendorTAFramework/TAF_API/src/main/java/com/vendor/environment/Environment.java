package com.vendor.environment;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Class is responsible for setting constant fields
 */

@Getter
@Setter
@ToString
public class Environment {

    public static String BASE_URL;
    public static String AUTH;

    public Environment() {
    }
}
