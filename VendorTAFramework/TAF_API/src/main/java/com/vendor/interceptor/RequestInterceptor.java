package com.vendor.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

@Slf4j
public class RequestInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        logRequest(request, body);
        ClientHttpResponse response = execution.execute(request, body);
        logResponse(response);
        return response;
    }

    private void logRequest(HttpRequest request, byte[] body) throws IOException {

        log.info("=================request begin=================");
        log.info("URI         : " + request.getURI());
        log.info("Method      : " + request.getMethod());
        log.info("Headers      : ");
        request.getHeaders().forEach((key, value) -> log.info(key + ": " + value));
//        log.info("Request body: " + new String(body, "UTF-8"));
        log.info("=================request end===================");
    }

    private void logResponse(ClientHttpResponse response) throws IOException {
        log.info("================response begin================");
        log.info("Status code  : " + response.getStatusCode());
        log.info("Headers      : ");
        response.getHeaders().forEach((key, value) -> log.info(key + ": " + value));
        //log.info("Response body: " + StreamUtils.copyToString(response.getBody(), Charset.defaultCharset()));
        log.info("================response end==================");
    }
}
