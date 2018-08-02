package com.ctmtest.denny.ctmtestapp.data;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.ctmtest.denny.ctmtestapp.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FetchImages {
    private Context context;

    public FetchImages(Context context){
        this.context = context;
    }


    public void getImageJSON() {
        /*Getting the JSON Object with Retrofit in first implementation the method show a
        * toast to the calling activity. Further implementation can implement User Friendly code or a status code return
         */
        ImageInterface booksInterface = RetrofitClient.getRetrofitInstance();
        final Call<ImageListObject> image = booksInterface.getImages();

        image.enqueue(new Callback<ImageListObject>() {
            @Override
            public void onResponse(Call<ImageListObject> call, Response<ImageListObject> response) {
                if (response.isSuccessful()) {
                } else {
                    Toast.makeText(context, R.string.ImageListAPI_errorr_message, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ImageListObject> call, Throwable t) {
                Toast.makeText(context, R.string.ImageListAPI_errorr_message, Toast.LENGTH_SHORT).show();
                Log.v("Retrofit has failed ", t.getMessage());
            }
        });
    }
}
