package com.sanguo.Implements;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;

/**
 * Created by jinrong on 2016/4/21.
 */
public class Implements_Parcelable implements Parcelable {

    public HashMap<String,String> mMap = new HashMap<String,String>();

    protected Implements_Parcelable(Parcel in) {
        mMap = in.readHashMap(HashMap.class.getClassLoader());
    }

    public static final Creator<Implements_Parcelable> CREATOR = new Creator<Implements_Parcelable>() {
        @Override
        public Implements_Parcelable createFromParcel(Parcel in) {
            return new Implements_Parcelable(in);
        }

        @Override
        public Implements_Parcelable[] newArray(int size) {
            return new Implements_Parcelable[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeMap(mMap);
    }
}

