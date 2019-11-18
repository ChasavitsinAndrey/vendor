package com.vendor;

import com.vendor.environment.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UberClientImpl extends ClientBaseImpl {

    private String baseUrl;
    private String token;

    public UberClientImpl() {
        baseUrl = Environment.BASE_URL;
        token = Environment.AUTH;
    }

    protected void addDefaultHeaders(Map<String, String> headers) {
//        headers.put("Authorization", token);
        headers.put("Content-Type", "application/json");
    }

    protected Map<String, String> getDefaultHeaders() {
        Map<String, String> headers = new HashMap<>();
        addDefaultHeaders(headers);
        return headers;
    }

    public <T, K> ResponseEntity<K> sendRequest(List<String> paths, Map<String, String> params, HttpMethod method, T elementBody, Class<K> responseType) {
        return sendRequest(baseUrl, paths, params, getDefaultHeaders(), method, elementBody, responseType);
    }

    public <K> ResponseEntity<K> sendGetRequest(List<String> paths, Map<String, String> params, Class<K> responseType) {
        return sendGetRequest(baseUrl, paths, params, getDefaultHeaders(), responseType);
    }

    public <T, K> ResponseEntity<K> sendPostRequest(List<String> paths, Map<String, String> params, T elementBody, Class<K> responseType) {
        return sendPostRequest(baseUrl, paths, params, getDefaultHeaders(), elementBody, responseType);
    }

    public <T, K> ResponseEntity<K> sendPutRequest(List<String> paths, Map<String, String> params, T elementBody, Class<K> responseType) {
        return sendPutRequest(baseUrl, paths, params, getDefaultHeaders(), elementBody, responseType);
    }

    public <T, K> ResponseEntity<K> sendPatchRequest(List<String> paths, Map<String, String> params, T elementBody, Class<K> responseType) {
        return sendPatchRequest(baseUrl, paths, params, getDefaultHeaders(), elementBody, responseType);
    }

    public <K> ResponseEntity<K> sendDeleteRequest(List<String> paths, Map<String, String> params, Class<K> responseType) {
        return sendDeleteRequest(baseUrl, paths, params, getDefaultHeaders(), responseType);
    }
}