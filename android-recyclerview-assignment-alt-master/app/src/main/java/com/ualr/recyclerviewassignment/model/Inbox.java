package com.ualr.recyclerviewassignment.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.lifecycle.ViewModel;

;
//TODO::Modify the inbox class so inbox object can be sent attached to an intent.
public class Inbox implements Parcelable {
    private String from;
    private String email;
    private String message;
    private String date;
    private boolean selected;

    public Inbox() {
        this.selected = false;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getInitial(){
       return String.valueOf(from.charAt(0));
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void toggleSelection() {
        this.selected = !this.selected;
    }

    public static final Parcelable.Creator<Inbox> CREATOR = new Parcelable.Creator<Inbox>() {
        @Override
        public Inbox createFromParcel(Parcel source) {
            return new Inbox(source);
        }

        @Override
        public Inbox[] newArray(int size) {
            return new Inbox[size];
        }
    };

    @Override
    public int describeContents(){
        return 0;
    }
    public void writeToParcel(Parcel parcel, int i){
        parcel.writeString(from);
        parcel.writeString(email);
        parcel.writeString(message);
        parcel.writeString(date);
    }
    protected Inbox(Parcel in){
        this.from = in.readString();
        this.email=in.readString();
        this.message=in.readString();
        this.date=in.readString();
    }
}