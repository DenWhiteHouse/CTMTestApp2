package com.ctmtest.denny.ctmtestapp.data;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/*
 * ENDPOINT: https://5ll6mbsq0e.execute-api.us-east-1.amazonaws.com/dev/picture/list
 * Schema autocreated by using http://www.jsonschema2pojo.org/
 */

public class ImageListObject implements Parcelable {

    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("like")
    @Expose
    private Integer like;
    @SerializedName("date")
    @Expose
    private String date;
    public final static Parcelable.Creator<ImageListObject> CREATOR = new Creator<ImageListObject>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ImageListObject createFromParcel(Parcel in) {
            return new ImageListObject(in);
        }

        public ImageListObject[] newArray(int size) {
            return (new ImageListObject[size]);
        }

    }
            ;

    protected ImageListObject(Parcel in) {
        this.image = ((String) in.readValue((String.class.getClassLoader())));
        this.like = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.date = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ImageListObject() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(image);
        dest.writeValue(like);
        dest.writeValue(date);
    }

    public int describeContents() {
        return 0;
    }

}
