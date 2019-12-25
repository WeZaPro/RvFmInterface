package com.taweesak.rvfminterface;

import android.os.Parcel;
import android.os.Parcelable;

public class MyModel extends MyParentModel {

    private String country;
    private int images;

    public MyModel() {
    }

    public MyModel(String country, int images) {
        this.country = country;
        this.images = images;
    }

    public MyModel(double rates, String country, int images) {
        super(rates);
        this.country = country;
        this.images = images;
    }

    public MyModel(Parcel in, String country, int images) {
        super(in);
        this.country = country;
        this.images = images;
    }

    public String getCountry() {
        return country;
    }

    /*public void setCountry(String country) {
        this.country = country;
    }*/

    public int getImages() {
        return images;
    }

    /*public void setImages(int images) {
        this.images = images;
    }*/
}
