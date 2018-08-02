package com.ctmtest.denny.ctmtestapp.data;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.ctmtest.denny.ctmtestapp.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FetchImages {

    public void getBookJSON() {
        //Getting the JSON Object with Retrofit
        ImageInterface booksInterface = RetrofitClient.getRetrofitInstance();
        final Call<ImageListObject> image = booksInterface.getImages();

        image.enqueue(new Callback<ImageListObject>() {
            @Override
            public void onResponse(Call<ImageListObject> call, Response<ImageListObject> response) {
                if (response.isSuccessful()) {
                } else {
                    //TODO: show messagge error
                }
            }

            @Override
            public void onFailure(Call<ImageListObject> call, Throwable t) {
                //TODO: add error message
                Log.v("Retrofit has failed ", t.getMessage());
            }
        });
    }
}
