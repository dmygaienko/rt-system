package com.mygaienko.rt_system.model;

import com.mygaienko.rt_system.model.alarm.Alarm;
import com.mygaienko.rt_system.model.interfaces.Positionable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmygaenko on 20/05/2016.
 */
public class WorkingArea {

    private final int length;
    private final int width;

    private final List<Alarm> alarms = new ArrayList<>();

    private final Position[][] positions;

    public WorkingArea(int length, int width) {
        this.length = length;
        this.width = width;

        positions = new Position[length][width];

        initPositions(length, width);
    }

    public WorkingArea() {
        length = 8;
        width = 6;

        positions = new Position[length][width];

        initPositions(length, width);

        initArea();
    }

    private void initArea() {
        Loader loader1 = new Loader(this, DirectedState.DOWN);
        setPositionable(loader1, 0, 0);

        Loader loader2 = new Loader(this, DirectedState.DOWN);
        setPositionable(loader2, 7, 5);

        Box box1 = new Box();
        setPositionable(box1, 3, 3);
        Box box2 = new Box();
        setPositionable(box2, 3, 4);
        Box box3 = new Box();
        setPositionable(box3, 4, 3);
        Box box4 = new Box();
        setPositionable(box4, 4, 4);
    }

    public Position getPosition(int x, int y) {
        return positions[x][y];
    }

    private void initPositions(int length, int width) {
        for (int x = 0; x < length; x++) {
            for (int y = 0; y < width; y++) {
                positions[x][y] = new Position(x, y);
            }
        }
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public boolean isAllowed(int x, int y) {
       return !isAlarm() && !isEngaged(x, y);
    }

    public boolean isEngaged(int x, int y) {
       return getPosition(x, y).getPositionable() != null;
    }

    public Positionable getPositionable(int x, int y) {
        return getPosition(x, y).getPositionable();
    }

    public void setPositionable(Positionable positionable, int x, int y) {
        Position position = getPosition(x, y);

        if (position.getPositionable() == null) {
            deleteCrossLink(positionable);

            position.setPositionable(positionable);
            positionable.setPosition(position);
        }
    }

    private void deleteCrossLink(Positionable positionable) {
        if (positionable.getPosition() != null) {
            positionable.getPosition().setPositionable(null);
        }
    }

    public boolean isAlarm() {
        return !alarms.isEmpty();
    }

    public void setAlarm(Alarm alarm) {
        alarms.add(alarm);
    }

    public void startProcess() {
        alarms.clear();
    }

}
