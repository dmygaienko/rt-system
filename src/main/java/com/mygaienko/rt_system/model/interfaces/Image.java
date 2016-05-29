package com.mygaienko.rt_system.model.interfaces;

/**
 * Created by enda1n on 28.05.2016.
 */
public interface Image {

    String getImageUrl();

    default boolean isShowing() {
        return true;
    }
}
