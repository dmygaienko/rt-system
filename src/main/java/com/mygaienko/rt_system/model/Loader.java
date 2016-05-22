package com.mygaienko.rt_system.model;

import com.mygaienko.rt_system.model.interfaces.Positionable;

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

    public static final int SIDE_DEGREES = 90;

    private WorkingArea area;

    private DirectionEnum direction;
    private Box loadedBox;

    public Loader(Position position) {
        super(position);
    }

    public Loader(WorkingArea area, DirectionEnum direction) {
        this.area = area;
        this.direction = direction;
    }

    public void moveForward(int steps) {
        for (int i = 0; i < steps; i++) {
            direction.step(steps, this, area);
        }
    }

    public void turnAround(int degrees) {
        DirectionEnum[] directions = DirectionEnum.values();

        int sides = degrees / SIDE_DEGREES;
        int i;
        if (sides > 0) {
            i = (direction.ordinal() + sides) % directions.length;
            direction = directions[i];
        }
    }

    public void putUpBox() {
        loadedBox = direction.putUpBox(this, area);
        loadedBox.getPosition().setPositionable(null);
        loadedBox.setPosition(getPosition());
    }

    public void putDownBox() {
        direction.step(1, loadedBox, area);
        loadedBox = null;
    }

    @Override
    public void setPosition(Position position) {
        if (loadedBox != null) {
            loadedBox.setPosition(position);
        }
        super.setPosition(position);
    }

    public DirectionEnum getDirection() {
        return direction;
    }

    public void setDirection(DirectionEnum direction) {
        this.direction = direction;
    }

}
