package com.vendor;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClientBaseImpl implements IClient {

    protected RestTemplate restTemplate;

    public ClientBaseImpl() {
       restTemplate = ClientConfig.getDefaultConfiguration();
    }

    public MultiValueMap<String, String> convertMapToMultiValueMap(Map<String, String> map) {
        MultiValueMap<String, String> result = new LinkedMultiValueMap<>();
        map.forEach((key, value) -> {
            List<String> listValue = new ArrayList<>();
            listValue.add(value);
            result.put(key, listValue);
        });
        return result;
    }

    public <T, K> ResponseEntity<K> sendRequest(String url, List<String> paths, Map<String, String> params, Map<String, String> headers, HttpMethod method, T elementBody, Class<K> responseType) {
        URI uri = buildUri(url, paths, convertMapToMultiValueMap(params));
        RequestEntity<T> request = new RequestEntity<>(elementBody, convertMapToMultiValueMap(headers), method, uri);
        ResponseEntity<K> response = restTemplate.exchange(request, responseType);
        return response;
    }

    public <K> ResponseEntity<K> sendGetRequest(String url, List<String> paths, Map<String, String> params, Map<String, String> headers, Class<K> responseType) {
        URI uri = buildUri(url, paths, convertMapToMultiValueMap(params));
        RequestEntity request = new RequestEntity<>(null, convertMapToMultiValueMap(headers), HttpMethod.GET, uri);
        ResponseEntity<K> response = restTemplate.exchange(request, responseType);
        return response;
    }

    public <T, K> ResponseEntity<K> sendPostRequest(String url, List<String> paths, Map<String, String> params, Map<String, String> headers, T elementBody, Class<K> responseType) {
        URI uri = buildUri(url, paths, convertMapToMultiValueMap(params));
        RequestEntity<T> request = new RequestEntity<>(elementBody, convertMapToMultiValueMap(headers), HttpMethod.POST, uri);
        ResponseEntity<K> response = restTemplate.exchange(request, responseType);
        return response;
    }

    public <T, K> ResponseEntity<K> sendPutRequest(String url, List<String> paths, Map<String, String> params, Map<String, String> headers, T elementBody, Class<K> responseType) {
        URI uri = buildUri(url, paths, convertMapToMultiValueMap(params));
        RequestEntity<T> request = new RequestEntity<>(elementBody, convertMapToMultiValueMap(headers), HttpMethod.PUT, uri);
        ResponseEntity<K> response = restTemplate.exchange(request, responseType);
        return response;
    }

    public <T, K> ResponseEntity<K> sendPatchRequest(String url, List<String> paths, Map<String, String> params, Map<String, String> headers, T elementBody, Class<K> responseType) {
        URI uri = buildUri(url, paths, convertMapToMultiValueMap(params));
        RequestEntity<T> request = new RequestEntity<>(elementBody, convertMapToMultiValueMap(headers), HttpMethod.PATCH, uri);
        ResponseEntity<K> response = restTemplate.exchange(request, responseType);
        return response;
    }

    public <K> ResponseEntity<K> sendDeleteRequest(String url, List<String> paths, Map<String, String> params, Map<String, String> headers, Class<K> responseType) {
        URI uri = buildUri(url, paths, convertMapToMultiValueMap(params));
        RequestEntity request = new RequestEntity(null, convertMapToMultiValueMap(headers), HttpMethod.DELETE, uri);
        ResponseEntity<K> response = restTemplate.exchange(request, responseType);
        return response;
    }

    public URI buildUri(String url, List<String> pathSegments, MultiValueMap<String, String> params) {
        String[] segments =
                pathSegments.stream()
                        .map(String::new)
                        .toArray(String[]::new);
        UriComponents uriComponents = UriComponentsBuilder
                .fromUriString(url)
                .pathSegment(segments)
                .queryParams(params)
                .build();
        return uriComponents.toUri();
    }
}