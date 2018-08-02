package com.ctmtest.denny.ctmtestapp.data;

import android.os.Parcel;
import android.os.Parcelable;

public class imageListObject  implements Parcelable{

    public final static Parcelable.Creator<imageListObject> CREATOR = new Creator<imageListObject>() {


        @SuppressWarnings({
                "unchecked"
        })
        public imageListObject createFromParcel(Parcel in) {
            return new imageListObject(in);
        }

        public imageListObject[] newArray(int size) {
            return (new imageListObject[][size]);
        }

    };
    @SerializedName("image")
    @Expose
    private Image imageo;
}
