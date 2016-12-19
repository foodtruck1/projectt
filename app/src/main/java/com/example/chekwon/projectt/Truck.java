package com.example.chekwon.projectt;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ArrayAdapter;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by Chekwon on 12/4/2016.
 */

public class Truck implements Parcelable {
    private String TruckName;
    private String foodCategory;
    private static final int NO_IMAGE=-1;
    private int imageResourceID=NO_IMAGE;

    public Truck(String TrkName, String foodcat ){
        TruckName=TrkName;
        foodCategory=foodcat;

    }

    public Truck(String TrkName, String foodcat, int imgNumberID){
        this.TruckName=TrkName;
        this.foodCategory=foodcat;
        this.imageResourceID=imgNumberID;
        //public ArrayList<Menu> Menu;
    }

    public String getTruckName(){
        return TruckName;
    }
    public String getCategory(){
        return foodCategory;
    }
    public int getImageResourceID(){return imageResourceID;}
    public boolean hasImage(){return imageResourceID!=NO_IMAGE;}

    public Truck (Parcel parcel){
        this.TruckName = parcel.readString();
        this.foodCategory = parcel.readString();
        this.imageResourceID= parcel.readInt();
   //     this.Menu = parcel.readArrayList(null);
    }

    @Override
    public int describeContents(){return 0;}

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(TruckName);
        dest.writeString(foodCategory);
        dest.writeInt(imageResourceID);
        //dest.writeList(Menu);
    }

    public static Creator<Truck> CREATOR = new Creator<Truck>() {

        @Override
        public Truck createFromParcel(Parcel source) {
            return new Truck(source);
        }

        @Override
        public Truck[] newArray(int size) {
            return new Truck[size];
        }

    };
    /*
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator(){

        @Override
        public Truck createFromParcel(Parcel in) {
            return new Truck(in);
        }

        @Override
        public Truck [] newArray(int i) {
            return new Truck[i];
        }
    };*/
}
