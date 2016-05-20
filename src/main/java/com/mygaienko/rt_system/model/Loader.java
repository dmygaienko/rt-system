package com.mygaienko.rt_system.model;

/**
 * Created by dmygaenko on 20/05/2016.
 */
public class Loader extends Positionable {

    public Loader(Position position) {
        super(position);
    }

    public void liftBox(Box box, Position position) {
        adjustSelfPosition(position);
    }

    public void moveBox(Box box, Position position) {
        adjustSelfPosition(position);
        box.setPosition(position);
    }

    private void adjustSelfPosition(Position position) {
        getPosition().setX(position.getX());
        getPosition().setY(position.getY());
    }
}
