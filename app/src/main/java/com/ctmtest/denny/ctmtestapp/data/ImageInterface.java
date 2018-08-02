package com.ctmtest.denny.ctmtestapp.data;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ImageInterface {
    @GET("picture/list")
    public Call<ArrayList<ImageListObject>> getImages();
}
