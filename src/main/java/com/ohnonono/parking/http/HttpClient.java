package com.ohnonono.parking.http;

import lombok.NonNull;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class HttpClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpClient.class);
    private static final OkHttpClient okHttpClient = new OkHttpClient();

    private HttpClient() {
    }

    public static HttpResponseWrapper sendGet(@NonNull HttpUrl httpUrl, Headers headers) {
        Request request = new Request.Builder()
                .url(httpUrl)
                .headers(headers)
                .build();

        try (Response response = okHttpClient.newCall(request).execute()) {
            String responseBody = response.body() == null ? "" : response.body().string();
            return new HttpResponseWrapper(response.code(), responseBody);
        } catch (IOException e) {
            LOGGER.error("Request {} failed", httpUrl);
            return new HttpResponseWrapper(400, "");
        }
    }

    public static HttpResponseWrapper sendGet(@NonNull String httpUrl, Headers headers) {
        Request request = new Request.Builder()
                .url(httpUrl)
                .headers(headers)
                .build();

        try (Response response = okHttpClient.newCall(request).execute()) {
            String responseBody = response.body() == null ? "" : response.body().string();
            return new HttpResponseWrapper(response.code(), responseBody);
        } catch (IOException e) {
            LOGGER.error("Request {} failed", httpUrl);
            return new HttpResponseWrapper(400, "");
        }
    }

    public static HttpResponseWrapper sendPost(@NonNull HttpUrl httpUrl, Headers headers, RequestBody requestBody) {
        Request request = new Request.Builder()
                .url(httpUrl)
                .headers(headers)
                .post(requestBody)
                .build();

        try (Response response = okHttpClient.newCall(request).execute()) {
            String responseBody = response.body() == null ? "" : response.body().string();
            return new HttpResponseWrapper(response.code(), responseBody);
        } catch (IOException e) {
            LOGGER.error("Request {} failed", httpUrl);
            return new HttpResponseWrapper(400, "");
        }
    }
}
