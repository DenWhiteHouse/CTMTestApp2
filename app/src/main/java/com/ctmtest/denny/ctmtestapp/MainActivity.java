package com.ctmtest.denny.ctmtestapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ctmtest.denny.ctmtestapp.data.FetchImages;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FetchImages imageFetcher;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
