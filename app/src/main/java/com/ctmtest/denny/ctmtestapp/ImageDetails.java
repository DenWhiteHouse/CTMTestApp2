package com.ctmtest.denny.ctmtestapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.ctmtest.denny.ctmtestapp.data.ImageListObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageDetails extends AppCompatActivity {
    @BindView(R.id.details_image)
    ImageView image;
    @BindView(R.id.item_date)
    TextView date;
    @BindView(R.id.item_likes)
    TextView likes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);

        Intent intent = getIntent();

    }

}
