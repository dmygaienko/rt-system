package com.mygaienko.rt_system.model;

/**
 * Created by dmygaenko on 20/05/2016.
 */
public class WorkingArea {

    private long length;
    private long width;

    public WorkingArea(long length, long width) {
        this.length = length;
        this.width = width;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public long getWidth() {
        return width;
    }

    public void setWidth(long width) {
        this.width = width;
    }
}
