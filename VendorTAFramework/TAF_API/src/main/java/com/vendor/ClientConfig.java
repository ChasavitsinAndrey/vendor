package com.vendor;

import com.vendor.interceptor.RequestInterceptor;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;


public class ClientConfig {

    public static RestTemplate getDefaultConfiguration() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().removeIf(m -> m.getClass().getName().equals(MappingJackson2HttpMessageConverter.class.getName()));
        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
        restTemplate.setInterceptors(Collections.singletonList(new RequestInterceptor()));
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {
            protected boolean hasError(HttpStatus statusCode) {
                return false;
            }
        });
        return restTemplate;
    }
}