package com.ctmtest.denny.ctmtestapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.Toast;

import com.ctmtest.denny.ctmtestapp.data.FetchImages;
import com.ctmtest.denny.ctmtestapp.data.ImageAdapter;
import com.ctmtest.denny.ctmtestapp.data.ImageInterface;
import com.ctmtest.denny.ctmtestapp.data.ImageListObject;
import com.ctmtest.denny.ctmtestapp.data.RetrofitClient;

import java.util.ArrayList;
import java.util.Comparator;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements MainActivityPresenter.View{
    @BindView(R.id.imagesGridRecylerViev)
    RecyclerView mRecyclerView;
    private MainActivityPresenter presenter;
    public ImageAdapter imageAdapter;
    FetchImages fetchImages = new FetchImages(this);
    private ArrayList<ImageListObject> responseObjectList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO: ADD CHECK onSavedStateInstance and Add List to a Bundle without refetching data
        responseObjectList = new ArrayList<ImageListObject>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
       // presenter = new MainActivityPresenter(this,this);
        getImageJSON();
    }

    @Override
    public void updateImagesView(){
        imageAdapter = new ImageAdapter(this,mRecyclerView);
        imageAdapter.setImageArrayList(responseObjectList);
        // Set Layout Manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        // TODO: CHANGE LINEARLAYOUT INTO GRIDVIEW

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(imageAdapter);
    }

    public void getImageJSON() {
        ImageInterface booksInterface = RetrofitClient.getRetrofitInstance();
        final Call<ArrayList<ImageListObject>> images = booksInterface.getImages();

        images.enqueue(new Callback<ArrayList<ImageListObject>>() {
            @Override
            public void onResponse(Call<ArrayList<ImageListObject>> call, Response<ArrayList<ImageListObject>> response) {
                if (response.isSuccessful()) {
                    responseObjectList = response.body();
                    updateImagesView();
                } else {
                    responseObjectList = null;
                    Toast.makeText(getApplicationContext(), R.string.ImageListAPI_errorr_message, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<ImageListObject>> call, Throwable t) {
                responseObjectList = null;
                Toast.makeText(getApplicationContext(), R.string.ImageListAPI_errorr_message, Toast.LENGTH_SHORT).show();
                Log.v("Retrofit has failed ", t.getMessage());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sort_by_likes:
                sortByLikes(responseObjectList);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void sortByLikes(ArrayList<ImageListObject> fetchedArrayList){
        // 
    }
}
