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
    private ArrayList<ImageListObject> responseObjectList;

    public FetchImages(Context context){
        this.context = context;
    }


    public ArrayList<ImageListObject> getImageJSON() {
        responseObjectList = new ArrayList<ImageListObject>();
        /*Getting the JSON Object with Retrofit in first implementation the method show a
        * toast to the calling activity. Further implementation can implement User Friendly code or a status code return
         */
        ImageInterface booksInterface = RetrofitClient.getRetrofitInstance();
        final Call<ArrayList<ImageListObject>> images = booksInterface.getImages();

        images.enqueue(new Callback<ArrayList<ImageListObject>>() {
            @Override
            public void onResponse(Call<ArrayList<ImageListObject>> call, Response<ArrayList<ImageListObject>> response) {
                if (response.isSuccessful()) {
                    responseObjectList =response.body();
                } else {
                    responseObjectList = null;
                    Toast.makeText(context, R.string.ImageListAPI_errorr_message, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<ImageListObject>> call, Throwable t) {
                responseObjectList = null;
                Toast.makeText(context, R.string.ImageListAPI_errorr_message, Toast.LENGTH_SHORT).show();
                Log.v("Retrofit has failed ", t.getMessage());
            }
        });
        return responseObjectList;
    }
}
