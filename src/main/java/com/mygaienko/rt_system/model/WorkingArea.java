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
            position.setPositionable(positionable);
            positionable.setPosition(position);
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
