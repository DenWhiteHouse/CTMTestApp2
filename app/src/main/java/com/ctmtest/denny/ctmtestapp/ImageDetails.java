package com.ctmtest.denny.ctmtestapp;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.ctmtest.denny.ctmtestapp.data.ImageAdapter;
import com.ctmtest.denny.ctmtestapp.data.ImageListObject;
import com.squareup.picasso.Picasso;

import java.sql.Date;
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
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
        intent =getIntent();
        updateView();
    }

    private void updateView(){
        //TODO: format Date
        date.setText(intent.getStringExtra(ImageAdapter.DATE));
        likes.setText(intent.getStringExtra(ImageAdapter.LIKES));
        Uri builtUri = Uri.parse(intent.getStringExtra(ImageAdapter.IMAGE)).buildUpon().build();
        //Resize
        Picasso.with(this)
                .load(builtUri)
                .into(image);
    }
}
