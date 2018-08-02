package com.ctmtest.denny.ctmtestapp;

import android.content.Context;
import android.view.View;

import com.ctmtest.denny.ctmtestapp.data.FetchImages;
import com.ctmtest.denny.ctmtestapp.data.ImageListObject;

import java.util.ArrayList;

public class MainActivityPresenter {
    private ArrayList<ImageListObject> imageArrayList;
    private View view;
    private FetchImages fetchImages;

    public MainActivityPresenter(View view){
        this.view=view;
        fetchImages = new FetchImages(view.getContext());
        imageArrayList = fetchImages.getImageJSON();
    }
}
