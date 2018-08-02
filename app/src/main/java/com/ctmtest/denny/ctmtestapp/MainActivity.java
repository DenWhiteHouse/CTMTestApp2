package com.ctmtest.denny.ctmtestapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.AbsListView;
import android.widget.GridView;

import com.ctmtest.denny.ctmtestapp.data.FetchImages;
import com.ctmtest.denny.ctmtestapp.data.ImageAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainActivityPresenter.View{
    @BindView(R.id.imagesGridRecylerViev)
    RecyclerView mRecyclerView;
    private MainActivityPresenter presenter;
    FetchImages fetchImages = new FetchImages(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new MainActivityPresenter(this,this);
    }

    @Override
    public void updateImagesView(){
        // Set Layout Manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(fetchImages.imageAdapter);
    }
}
