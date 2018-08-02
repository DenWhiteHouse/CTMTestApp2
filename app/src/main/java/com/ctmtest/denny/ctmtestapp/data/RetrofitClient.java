package com.ctmtest.denny.ctmtestapp.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class RetrofitClient {
    static String ROOT_URL = "https://5ll6mbsq0e.execute-api.us-east-1.amazonaws.com/dev/";
    static ImageInterface ImageInterface;

    public static ImageInterface getRetrofitInstance() {
        Gson gson = new GsonBuilder().create();
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        ImageInterface = new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .callFactory(httpClientBuilder.build())
                .build().create(ImageInterface.class);
        return ImageInterface;
    }
}
