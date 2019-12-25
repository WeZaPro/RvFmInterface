package com.taweesak.rvfminterface;

import android.os.Parcel;
import android.os.Parcelable;

public class MyParentModel implements Parcelable {

    private double rates;

    public MyParentModel() {
    }

    public MyParentModel(double rates) {
        this.rates = rates;
    }

    protected MyParentModel(Parcel in) {
        rates = in.readDouble();
    }

    public static final Creator<MyParentModel> CREATOR = new Creator<MyParentModel>() {
        @Override
        public MyParentModel createFromParcel(Parcel in) {
            return new MyParentModel(in);
        }

        @Override
        public MyParentModel[] newArray(int size) {
            return new MyParentModel[size];
        }
    };

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
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(rates);
    }
}
