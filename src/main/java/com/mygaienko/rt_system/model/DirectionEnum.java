package com.mygaienko.rt_system.model;

import com.mygaienko.rt_system.model.interfaces.Positionable;
import com.mygaienko.rt_system.model.interfaces.Stepable;

/**
 * Created by dmygaenko on 20/05/2016.
 */
public enum DirectionEnum implements Stepable {

    UP {
        public void step(long steps, Positionable positionable, WorkingArea area) {
            if (reachHorizontalBound(-steps, positionable, area)) {
            }

            for (int i = 0; i < steps; i++) {
                Position position = positionable.getPosition();
                positionable.setPosition(new Position(position.getX(), position.getY() - 1));
            }
        }
    },
    RIGHT {
        public void step(long steps, Positionable positionable, WorkingArea area) {
            if (reachVerticalBound(-steps, positionable, area)) {
            }

            for (int i = 0; i < steps; i++) {
                Position position = positionable.getPosition();
                positionable.setPosition(new Position(position.getX() + 1, position.getY()));
            }
        }
    },
    DOWN {
        public void step(long steps, Positionable positionable, WorkingArea area) {
            if (reachHorizontalBound(steps, positionable, area)) {
            }

            for (int i = 0; i < steps; i++) {
                Position position = positionable.getPosition();
                positionable.setPosition(new Position(position.getX(), position.getY() + 1));
            }
        }
    },
    LEFT {
        public void step(long steps, Positionable positionable, WorkingArea area) {
            if (reachVerticalBound(steps, positionable, area)) {
            }

            for (int i = 0; i < steps; i++) {
                Position position = positionable.getPosition();
                positionable.setPosition(new Position(position.getX() - 1, position.getY()));
            }
        }
    };

    private static boolean reachVerticalBound(long l, Positionable positionable, WorkingArea area) {
        long target = positionable.getPosition().getX() + l;
        return target >= 0 && target < area.getLength();
    }

    private static boolean reachHorizontalBound(long l, Positionable positionable, WorkingArea area) {
        long target = positionable.getPosition().getY() + l;
        return target >= 0 && target < area.getWidth();
    }

}
