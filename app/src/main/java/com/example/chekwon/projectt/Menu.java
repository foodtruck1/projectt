package com.example.chekwon.projectt;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ArrayAdapter;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by Chekwon on 12/16/2016.
 */

public class Menu implements Parcelable {
    private String DishName;
    private String Description;
    private static final int NO_IMAGE=-1;
    private int imageResourceID=NO_IMAGE;

    public Menu(String DsName, String Desc ){
        DishName=DsName;
        Description=Desc;
    }
    public Menu(String DsName, String Desc, int imgNumberID){
        this.DishName=DsName;
        this.Description=Desc;
        this.imageResourceID=imgNumberID;
        //public ArrayList<Menu> Menu;
    }
    public String getMenuName(){
        return DishName;
    }
    public String getDescription(){
        return Description;
    }
    public int getImageResourceID(){return imageResourceID;}
    public boolean hasImage(){return imageResourceID!=NO_IMAGE;}

    public Menu(Parcel parcel){
        this.DishName = parcel.readString();
        this.Description = parcel.readString();
        this.imageResourceID= parcel.readInt();
        //     this.Menu = parcel.readArrayList(null);
    }

    @Override
    public int describeContents(){return 0;}

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(DishName);
        dest.writeString(Description);
        dest.writeInt(imageResourceID);
        //dest.writeList(Menu);
    }

    public static Creator<Menu> CREATOR = new Creator<Menu>() {
        @Override
        public Menu createFromParcel(Parcel source) {
            return new Menu(source);
        }

        @Override
        public Menu[] newArray(int size) {
            return new Menu[size];
        }

    };

}
