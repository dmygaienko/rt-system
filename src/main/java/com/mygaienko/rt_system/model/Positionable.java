package com.mygaienko.rt_system.model;

/**
 * Created by dmygaenko on 20/05/2016.
 */
abstract class Positionable {

    private Position position;

    public Positionable(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
