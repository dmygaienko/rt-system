package com.mygaienko.rt_system.model;

/**
 * Commands:
 *      move forward on * steps
 *      turn on
 *      put up box
 *      put down box
 *
 * Created by dmygaenko on 20/05/2016.
 */
public class Loader extends Positionable {

    private WorkingArea workingArea;
    private DirectionEnum direction;
    private boolean loaded;

    public Loader(Position position) {
        super(position);
    }

    public void moveForward(long steps) {
    }

    public void turnOn(int degrees) {
    }

    public void putUpBox(Box box) {
    }

    public void putDownBox(Box box) {
    }

}
