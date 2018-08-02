package com.ctmtest.denny.ctmtestapp;

import android.view.View;

import com.ctmtest.denny.ctmtestapp.data.ImageListObject;

import java.util.ArrayList;

public class MainActivityPresenter {
    private ArrayList<ImageListObject> imageArrayList;
    private View view;

    public MainActivityPresenter(View view){
        this.view=view;
    }
}
