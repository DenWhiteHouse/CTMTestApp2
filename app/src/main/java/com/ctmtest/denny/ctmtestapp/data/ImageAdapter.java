package com.ctmtest.denny.ctmtestapp.data;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ctmtest.denny.ctmtestapp.MainActivity;
import com.ctmtest.denny.ctmtestapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
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
    public void onBindViewHolder(ImageAdapter.ViewHolder holder, int position) {
        // inflates the elements into the view
        ImageListObject imageListObject = imagesArrayList.get(position);
        Uri builtUri = Uri.parse(imageListObject.getImage()).buildUpon().build();
        Picasso.with(mContext).load(builtUri).into(holder.mImageView);
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

