package com.mygaienko.rt_system.model;

import com.mygaienko.rt_system.model.interfaces.Positionable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private static final Logger logger = LoggerFactory.getLogger(Loader.class);

    public static final int SIDE_DEGREES = 90;

    private WorkingArea area;

    private DirectedState direction;
    private Box loadedBox;

    public Loader(WorkingArea area, DirectedState direction) {
        this.area = area;
        this.direction = direction;
    }

    @Override
    public String getImageUrl() {
        return loadedBox == null ? direction.getImageUrl() : direction.getLoadedImageUrl();
    }

    public void moveForward(int steps) {
        for (int i = 0; i < steps; i++) {
            direction.step(1, this, area);
        }
    }

    public void turnAround(int degrees) {
        DirectedState[] directions = DirectedState.values();

        int sides = degrees / SIDE_DEGREES;
        int i;
        if (sides > 0) {
            i = (direction.ordinal() + sides) % directions.length;
            direction = directions[i];
        }

        logger.info("turned around on {} degrees", degrees);
    }

    public void putUpBox() {
        loadedBox = direction.getPutBox(this, area);
        loadedBox.getPosition().setPositionable(null);
        loadedBox.setPosition(getPosition());
        loadedBox.setLoaded(true);

        logger.info("put up box from {}", direction.name().toLowerCase());
    }

    public void putDownBox() {
        direction.step(1, loadedBox, area);
        loadedBox.setLoaded(false);
        loadedBox = null;

        logger.info("put down box to the {}", direction.name().toLowerCase());
    }

    @Override
    public void setPosition(Position position) {
        if (loadedBox != null) {
            loadedBox.setPosition(position);
        }
        super.setPosition(position);
    }

    public DirectedState getDirection() {
        return direction;
    }

}
