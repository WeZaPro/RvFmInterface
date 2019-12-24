package com.taweesak.rvfminterface;

import android.os.Parcel;
import android.os.Parcelable;

public class MyModel implements Parcelable {

    private String country;
    private double rates;

    public MyModel() {
    }

    public MyModel(String country, double rates) {
        this.country = country;
        this.rates = rates;
    }

    protected MyModel(Parcel in) {
        country = in.readString();
        rates = in.readDouble();
    }

    public static final Creator<MyModel> CREATOR = new Creator<MyModel>() {
        @Override
        public MyModel createFromParcel(Parcel in) {
            return new MyModel(in);
        }

        @Override
        public MyModel[] newArray(int size) {
            return new MyModel[size];
        }
    };

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getRates() {
        return rates;
    }

    public void setRates(double rates) {
        this.rates = rates;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(country);
        parcel.writeDouble(rates);
    }
}
