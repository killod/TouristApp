package com.example.masukov.touristapp;

import android.support.v4.app.Fragment;


public class AttractionActivity extends SingleFragmentActivity {

    protected Fragment createFragment(){
        return new AttractionFragment();
    }
}
