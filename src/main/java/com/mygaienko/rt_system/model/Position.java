package com.mygaienko.rt_system.model;

import com.mygaienko.rt_system.model.interfaces.Positionable;

/**
 * Created by dmygaenko on 20/05/2016.
 */
public class Position {

    private final int x;
    private final int y;

    private Positionable positionable;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Positionable getPositionable() {
        return positionable;
    }

    public void setPositionable(Positionable positionable) {
        this.positionable = positionable;
    }
}
