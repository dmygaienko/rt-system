package com.mygaienko.rt_system.model;

import com.mygaienko.rt_system.model.interfaces.LoaderImage;
import com.mygaienko.rt_system.model.interfaces.Positionable;
import com.mygaienko.rt_system.model.interfaces.State;

/**
 * Created by dmygaenko on 20/05/2016.
 */
public enum DirectedState implements State, LoaderImage {

    UP {
        @Override
        public String getImageUrl() {
            return "/image/loader-up.jpg";
        }

        @Override
        public String getLoadedImageUrl() {
            return "/image/loader-loaded-up.jpg";
        }

        @Override
        public void step(int steps, Positionable positionable, WorkingArea area) {
            if (reachHorizontalBound(-steps, positionable, area)) {
                return;
            }

            for (int i = 0; i < steps; i++) {
                doStep(positionable, positionable.getX(), positionable.getY() - 1, area);
            }
        }

        @Override
        public Box putUpBox(Positionable positionable, WorkingArea area) {
            return (Box) area.getPositionable(positionable.getX(), positionable.getY() - 1);
        }
    },
    RIGHT {
        @Override
        public String getImageUrl() {
            return "/image/loader-right.jpg";
        }

        @Override
        public String getLoadedImageUrl() {
            return "/image/loader-loaded-right.jpg";
        }

        @Override
        public void step(int steps, Positionable positionable, WorkingArea area) {
            if (reachVerticalBound(steps, positionable, area)) {
                return;
            }

            for (int i = 0; i < steps; i++) {
                doStep(positionable, positionable.getX() + 1, positionable.getY(), area);
            }
        }

        @Override
        public Box putUpBox(Positionable positionable, WorkingArea area) {
            return (Box) area.getPositionable(positionable.getX() + 1, positionable.getY());
        }
    },
    DOWN {
        @Override
        public String getImageUrl() {
            return "/image/loader-down.jpg";
        }

        @Override
        public String getLoadedImageUrl() {
            return "/image/loader-loaded-down.jpg";
        }

        @Override
        public void step(int steps, Positionable positionable, WorkingArea area) {
            if (reachHorizontalBound(steps, positionable, area)) {
                return;
            }

            for (int i = 0; i < steps; i++) {
                doStep(positionable, positionable.getX(), positionable.getY() + 1, area);
            }
        }

        @Override
        public Box putUpBox(Positionable positionable, WorkingArea area) {
            return (Box) area.getPositionable(positionable.getX(), positionable.getY() + 1);
        }
    },
    LEFT {
        @Override
        public String getImageUrl() {
            return "/image/loader-left.jpg";
        }

        @Override
        public String getLoadedImageUrl() {
            return "/image/loader-loaded-left.jpg";
        }

        @Override
        public void step(int steps, Positionable positionable, WorkingArea area) {
            if (reachVerticalBound(-steps, positionable, area)) {
                return;
            }

            for (int i = 0; i < steps; i++) {
                doStep(positionable, positionable.getX() - 1, positionable.getY(), area);
            }
        }

        @Override
        public Box putUpBox(Positionable positionable, WorkingArea area) {
            return (Box) area.getPositionable(positionable.getX() - 1, positionable.getY());
        }
    };

    protected void doStep(Positionable positionable, int x, int y, WorkingArea area) {
        if (area.isAllowed(x, y)) {
            Position position = area.getPosition(x, y);
            position.setPositionable(positionable);
            positionable.setPosition(position);
        }
    }

    protected boolean reachVerticalBound(int steps, Positionable positionable, WorkingArea area) {
        long target = positionable.getX() + steps;
        return target < 0 || target >= area.getLength();
    }

    protected boolean reachHorizontalBound(int steps, Positionable positionable, WorkingArea area) {
        long target = positionable.getY() + steps;
        return target < 0 || target >= area.getWidth();
    }

}
