package com.ctmtest.denny.ctmtestapp.data;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.ctmtest.denny.ctmtestapp.MainActivity;
import com.ctmtest.denny.ctmtestapp.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FetchImages {
    /*
    Data directly fetched from Main, this class can be used if implemented a CallBack onResponse to communicate when the object has arrived
    and stop an eventual progressBar
     */
    private Context context;
    private ArrayList<ImageListObject> responseObjectList;

    public FetchImages(Context context){
        responseObjectList = new ArrayList<ImageListObject>();
        this.context = context;
        getImageJSON();
    }


    public void getImageJSON() {
        ImageInterface booksInterface = RetrofitClient.getRetrofitInstance();
        final Call<ArrayList<ImageListObject>> images = booksInterface.getImages();

        images.enqueue(new Callback<ArrayList<ImageListObject>>() {
            @Override
            public void onResponse(Call<ArrayList<ImageListObject>> call, Response<ArrayList<ImageListObject>> response) {
                if (response.isSuccessful()) {
                    setResponseObjectList(response.body());
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
    }

    public ArrayList<ImageListObject> getResponseObjectList(){
        return responseObjectList;
    }

    public void setResponseObjectList(ArrayList<ImageListObject> arrayList){
        responseObjectList = arrayList;
    }

    public ArrayList<ImageListObject> getArrayFromCall(){
        getImageJSON();
        return responseObjectList;
    }
}
