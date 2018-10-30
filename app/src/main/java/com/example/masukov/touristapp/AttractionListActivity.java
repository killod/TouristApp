package com.example.masukov.touristapp;

import android.support.v4.app.Fragment;

public class AttractionListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment(){
        return new AttractionListFragment();
    }

}
