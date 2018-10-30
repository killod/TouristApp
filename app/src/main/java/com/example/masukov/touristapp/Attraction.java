package com.example.masukov.touristapp;

import java.util.Date;
import java.util.TimeZone;
import java.util.UUID;

public class Attraction {

    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSeen;
    

    public Attraction(){
        mId=UUID.randomUUID();
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/Moscow"));
        mDate = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSeen() {
        return mSeen;
    }

    public void setSeen(boolean seen) {
        mSeen = seen;
    }
}
