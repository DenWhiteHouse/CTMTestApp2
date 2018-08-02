package com.ctmtest.denny.ctmtestapp.data;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.ctmtest.denny.ctmtestapp.ImageDetails;
import com.ctmtest.denny.ctmtestapp.MainActivity;
import com.ctmtest.denny.ctmtestapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    //String for Passing Strings via Inent
    public static final String IMAGE = "IMAGE_PATH";
    public static final String LIKES = "LIKES";
    public static final String DATE = "DATES";

    private ArrayList<ImageListObject> imagesArrayList;
    private LayoutInflater inflater;
    private Context mContext;
    private RecyclerView mRecyclerView;

    public ImageAdapter(Context context,RecyclerView recyclerView){
        mContext = context;
        mRecyclerView = recyclerView;
    }

    @Override
    public ImageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = mContext;
        this.inflater = LayoutInflater.from(context);
        // create a new view
        View v = inflater.inflate(R.layout.image_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ImageAdapter.ViewHolder viewholder = new ImageAdapter.ViewHolder(v);
        return viewholder;
    }

    public void setImageArrayList(ArrayList<ImageListObject> imageArrayList){
        imagesArrayList = imageArrayList;
    }

    @Override
    public int getItemCount() {
        return this.imagesArrayList.size();
    }

    @Override
    public void onBindViewHolder(final ImageAdapter.ViewHolder holder, final int position) {
        // inflates the elements into the view
        final ImageListObject imageListObject = imagesArrayList.get(position);
        Uri builtUri = Uri.parse(imageListObject.getImage()).buildUpon().build();
        Picasso.with(mContext).load(builtUri).into(holder.mImageView);
        holder.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ToastMessage to test onClickListener
                Toast.makeText(mContext,imageListObject.getLike().toString(),Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(mContext,ImageDetails.class);
                intent.putExtra(IMAGE,imageListObject.getImage());
                intent.putExtra(LIKES,imageListObject.getLike().toString());
                intent.putExtra(DATE,imageListObject.getDate());
                mContext.startActivity(intent);
            }
        });
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;

        ViewHolder(View v) {
            super(v);
            mImageView = v.findViewById(R.id.imageItem);

        }

        public Context getContext() {
            return mContext;
        }
    }
}

