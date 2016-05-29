package com.mygaienko.rt_system.model;

import com.mygaienko.rt_system.model.interfaces.Positionable;

/**
 * Created by dmygaenko on 20/05/2016.
 */
public class Box extends Positionable {

    public static final String IMG_URL = "/image/box.jpg";

    private boolean loaded = false;

    public Box() {
    }

    @Override
    public String getImageUrl() {
        return IMG_URL;
    }

    @Override
    public boolean isShowing() {
        return !loaded;
    }

    public void setLoaded(boolean loaded) {
        this.loaded = loaded;
    }
}
