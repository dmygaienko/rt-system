package com.mygaienko.rt_system.model.interfaces;

import com.mygaienko.rt_system.model.Position;

/**
 * Created by dmygaenko on 20/05/2016.
 */
public abstract class Positionable {

    private Position position;

    public Positionable() {
    }

    public Positionable(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getY() {
        return position.getY();
    }

    public int getX() {
        return position.getX();
    }
}
