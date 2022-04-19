package com.example.search_project_final.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Menu implements Parcelable
{
    private String item_name;
    private String url;
    private float item_price;

    protected Menu(Parcel in) {
        item_name = in.readString();
        url = in.readString();
        item_price = in.readFloat();
    }

    public static final Creator<Menu> CREATOR = new Creator<Menu>() {
        @Override
        public Menu createFromParcel(Parcel in) {
            return new Menu(in);
        }

        @Override
        public Menu[] newArray(int size) {
            return new Menu[size];
        }
    };

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public float getItem_price() {
        return item_price;
    }

    public void setItem_price(float item_price) {
        this.item_price = item_price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(item_name);
        parcel.writeString(url);
        parcel.writeFloat(item_price);
    }
}
