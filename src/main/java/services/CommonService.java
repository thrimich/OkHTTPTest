package services;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;
import java.util.Objects;

import static utils.GsonResourcesUtils.convertJSONToPOJO;
import static utils.GsonResourcesUtils.convertToJSON;

public abstract class CommonService {

    protected String servicePath;
    protected String serviceEndpoint;

    public CommonService() {
        this.serviceEndpoint = buildEndPoint();
    }

    protected abstract String buildEndPoint();
    protected abstract void addAuthenticationHeaders();


    protected <T> T get(OkHttpClient okHttpClient, String url, String headers, Class<T> responseClass){
        String json = "";

        Request request = new Request.Builder()
//                .addHeader("","")
                .url(url)
                .build();

        try {
            json = Objects.requireNonNull(okHttpClient.newCall(request).execute().body()).string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  convertJSONToPOJO(json,responseClass);
    }

    protected <T> T[] getForList(OkHttpClient okHttpClient, String url, String headers, Class<T[]> responseClass){
        String json = "";

        Request request = new Request.Builder()
//                .addHeader("","")
                .url(url)
                .build();

        try {
            json = Objects.requireNonNull(okHttpClient.newCall(request).execute().body()).string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  convertJSONToPOJO(json,responseClass);
    }

    protected <T> T put(OkHttpClient okHttpClient, String url, String headers, Object body,Class<T> responseClass){
        String json = "";
        RequestBody requestBody = RequestBody.create(convertToJSON(body),MediaType.parse("application/json"));
        Request request = new Request.Builder()
//                .addHeader("","")
                .put(requestBody)
                .url(url)
                .build();

        try {
            json = Objects.requireNonNull(okHttpClient.newCall(request).execute().body()).string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  convertJSONToPOJO(json,responseClass);
    }

    protected <T> T post(OkHttpClient okHttpClient, String url, String headers, Object body,Class<T> responseClass){
        String json = "";
        RequestBody requestBody = RequestBody.create(convertToJSON(body),MediaType.parse("application/json"));
        Request request = new Request.Builder()
//                .addHeader("","")
                .post(requestBody)
                .url(url)
                .build();

        try {
            json = Objects.requireNonNull(okHttpClient.newCall(request).execute().body()).string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  convertJSONToPOJO(json,responseClass);
    }

    protected <T> T[] postForList(OkHttpClient okHttpClient, String url, String headers, Object body, Class<T[]> responseClass){
        String json = "";
        RequestBody requestBody = RequestBody.create(convertToJSON(body),MediaType.parse("application/json"));
        Request request = new Request.Builder()
//                .addHeader("","")
                .post(requestBody)
                .url(url)
                .build();

        try {
            json = Objects.requireNonNull(okHttpClient.newCall(request).execute().body()).string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  convertJSONToPOJO(json,responseClass);
    }

    protected <T> T delete(OkHttpClient okHttpClient, String url, String headers, Class<T> responseClass){
        String json = "";
        Request request = new Request.Builder()
//                .addHeader("","")
                .delete()
                .url(url)
                .build();

        try {
            json = Objects.requireNonNull(okHttpClient.newCall(request).execute().body()).string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  convertJSONToPOJO(json,responseClass);
    }
}
