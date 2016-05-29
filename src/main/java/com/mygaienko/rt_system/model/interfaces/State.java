package com.mygaienko.rt_system.model.interfaces;

import com.mygaienko.rt_system.model.Box;
import com.mygaienko.rt_system.model.Position;
import com.mygaienko.rt_system.model.WorkingArea;

/**
 * Created by enda1n on 21.05.2016.
 */
public interface State {

    void step(int steps, Positionable position, WorkingArea area);

    Box putUpBox(Positionable positionable, WorkingArea area);

    default void doStep(Positionable positionable, int x, int y, WorkingArea area) {
        if (area.isAllowed(x, y)) {
            Position position = area.getPosition(x, y);
            position.setPositionable(positionable);
            positionable.setPosition(position);
        }
    }

    default boolean reachVerticalBound(int steps, Positionable positionable, WorkingArea area) {
        long target = positionable.getX() + steps;
        return target < 0 || target >= area.getLength();
    }

    default boolean reachHorizontalBound(int steps, Positionable positionable, WorkingArea area) {
        long target = positionable.getY() + steps;
        return target < 0 || target >= area.getWidth();
    }
}
