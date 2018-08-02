package com.ctmtest.denny.ctmtestapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ctmtest.denny.ctmtestapp.data.ImageListObject;

import java.util.ArrayList;

import butterknife.ButterKnife;

public class ImageDetails extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

}
