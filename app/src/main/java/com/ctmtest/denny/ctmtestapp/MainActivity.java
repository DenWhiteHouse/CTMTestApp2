package com.ctmtest.denny.ctmtestapp;

import android.content.Intent;
import android.os.PersistableBundle;
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
import java.util.Collections;
import java.util.Comparator;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements MainActivityPresenter.View{
    private static final String bundleList ="LIST";
    @BindView(R.id.imagesGridRecylerViev)
    RecyclerView mRecyclerView;
    private MainActivityPresenter presenter;
    public ImageAdapter imageAdapter;
    FetchImages fetchImages = new FetchImages(this);
    private ArrayList<ImageListObject> responseObjectList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        responseObjectList = new ArrayList<ImageListObject>();

        if(savedInstanceState == null) {
            // Use Retrofit to get the JSON from the ENDPOIN
            getImageJSON();
        }
        else
        {
            //get the Array from Bundle instead of fetching again Data from the Web
            responseObjectList = savedInstanceState.getParcelableArrayList(bundleList);
            updateImagesView();
        }
    }

    @Override
    public void updateImagesView(){
        //Set the imageAdapter
        imageAdapter = new ImageAdapter(this,mRecyclerView);
        imageAdapter.setImageArrayList(responseObjectList);
        // Set Layout Manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        // TODO: CHANGE LINEARLAYOUT INTO GRIDVIEW
        // Set the RecyclerView
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
                    // if the response isSuccessful put the body to responseObjectList and populate the view
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
        Collections.sort(fetchedArrayList, new Comparator<ImageListObject>() {
            public int compare(ImageListObject objectOne, ImageListObject objectTwo) {
                if (objectOne.getLike() == objectTwo.getLike()) {
                    return 0;
                }
                return objectOne.getLike() < objectTwo.getLike() ? -1 : 1;
            }
        });
        responseObjectList = fetchedArrayList;
        updateImagesView();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        if (responseObjectList != null) {
            outState.putParcelableArrayList(bundleList, responseObjectList);
            super.onSaveInstanceState(outState);
        }
    }
}
