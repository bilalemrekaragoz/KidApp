package com.example.KidApp;

import android.media.Image;

public class Animals {

    String name;
    int image;


    public Animals(String name, int image) {
        this.name=name;
        this.image=image;
    }

    public Animals()
    {

    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }
}
