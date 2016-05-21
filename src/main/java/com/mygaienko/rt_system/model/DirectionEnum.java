package com.mygaienko.rt_system.model;

import com.mygaienko.rt_system.model.interfaces.Positionable;
import com.mygaienko.rt_system.model.interfaces.Stepable;

/**
 * Created by dmygaenko on 20/05/2016.
 */
public enum DirectionEnum implements Stepable {

    UP {
        public void step(int steps, Positionable positionable, WorkingArea area) {
            if (reachHorizontalBound(-steps, positionable, area)) {
            }

            for (int i = 0; i < steps; i++) {
                doStep(positionable, positionable.getX(), positionable.getY() - 1, area);
            }
        }
    },
    RIGHT {
        public void step(int steps, Positionable positionable, WorkingArea area) {
            if (reachVerticalBound(-steps, positionable, area)) {
            }

            for (int i = 0; i < steps; i++) {
                doStep(positionable, positionable.getX() + 1, positionable.getY(), area);
            }
        }
    },
    DOWN {
        public void step(int steps, Positionable positionable, WorkingArea area) {
            if (reachHorizontalBound(steps, positionable, area)) {
            }

            for (int i = 0; i < steps; i++) {
                doStep(positionable, positionable.getX(), positionable.getY() + 1, area);
            }
        }
    },
    LEFT {
        public void step(int steps, Positionable positionable, WorkingArea area) {
            if (reachVerticalBound(steps, positionable, area)) {
            }

            for (int i = 0; i < steps; i++) {
                doStep(positionable, positionable.getX() - 1, positionable.getY(), area);
            }
        }
    }
}
