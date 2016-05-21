package com.mygaienko.rt_system.model;

/**
 * Created by dmygaenko on 20/05/2016.
 */
public class Position implements Cloneable {

    private long x;
    private long y;

    public Position(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public long getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }

    public long getY() {
        return y;
    }

    public void setY(long y) {
        this.y = y;
    }

    public Position clone() {
        return new Position(y, y);
    }


}
