package com.vendor;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface IClient {

    <T, K> ResponseEntity<K> sendRequest(String url, List<String> paths, Map<String, String> params, Map<String, String> headers,
                                         HttpMethod method, T elementBody, Class<K> responseType);

    <K> ResponseEntity<K> sendGetRequest(String url, List<String> paths, Map<String, String> params, Map<String, String> headers,
                                         Class<K> responseType);

    <T, K> ResponseEntity<K> sendPostRequest(String url, List<String> paths, Map<String, String> params, Map<String, String> headers,
                                             T elementBody, Class<K> responseType);

    <T, K> ResponseEntity<K> sendPutRequest(String url, List<String> paths, Map<String, String> params, Map<String, String> headers,
                                            T elementBody, Class<K> responseType);

    <T, K> ResponseEntity<K> sendPatchRequest(String url, List<String> paths, Map<String, String> params, Map<String, String> headers,
                                              T elementBody, Class<K> responseType);

    <K> ResponseEntity<K> sendDeleteRequest(String url, List<String> paths, Map<String, String> params, Map<String, String> headers,
                                            Class<K> responseType);
}
