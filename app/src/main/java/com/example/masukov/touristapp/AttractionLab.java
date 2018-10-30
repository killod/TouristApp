package com.example.masukov.touristapp;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AttractionLab {

    private static AttractionLab sCrimeLab;
    private List<Attraction> mAttractions;

    public static AttractionLab get(Context context) {
        if (sCrimeLab == null) {
            sCrimeLab = new AttractionLab(context);
        }
        return sCrimeLab;
    }

    private AttractionLab(Context context) {
        mAttractions = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Attraction attraction = new Attraction();
            attraction.setTitle("Attraction #" + i);
            attraction.setSeen(i % 2 == 0); // Для каждого второго объекта
            mAttractions.add(attraction);
        }
    }

    public List<Attraction> getAttractions() {
        return mAttractions;
    }

    public Attraction getAttraction(UUID id) {
        for (Attraction attraction : mAttractions) {
            if (attraction.getId().equals(id)) {
                return attraction;
            }
        }
        return null;
    }


}
