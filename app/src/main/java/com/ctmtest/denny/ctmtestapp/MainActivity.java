package com.ctmtest.denny.ctmtestapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.ctmtest.denny.ctmtestapp.data.FetchImages;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainActivityPresenter.View{
    @BindView(R.id.GridView)
    GridView mainGrid;
    private MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new MainActivityPresenter(this,this);
    }

    @Override
    public void updateImagesView(){
        for(int i= 0;i<presenter.getImagesListSize();i++){
        }
    }
}
