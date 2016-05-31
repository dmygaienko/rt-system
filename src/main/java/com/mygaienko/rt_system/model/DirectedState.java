package com.mygaienko.rt_system.model;

import com.mygaienko.rt_system.model.interfaces.LoaderImage;
import com.mygaienko.rt_system.model.interfaces.Positionable;
import com.mygaienko.rt_system.model.interfaces.State;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        public Box getPutBox(Positionable positionable, WorkingArea area) {
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
        public Box getPutBox(Positionable positionable, WorkingArea area) {
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
        public Box getPutBox(Positionable positionable, WorkingArea area) {
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
        public Box getPutBox(Positionable positionable, WorkingArea area) {
            return (Box) area.getPositionable(positionable.getX() - 1, positionable.getY());
        }
    };

    private static final Logger logger = LoggerFactory.getLogger(Loader.class);

    private static final String HORIZONTAL = "horizontal";
    private static final String VERTICAL = "vertical";

    protected void doStep(Positionable positionable, int x, int y, WorkingArea area) {
        Lock.lock();
        boolean allowed = area.isAllowed(x, y);
        if (allowed) {
            clearCurrentPosition(positionable);
            logStep(positionable);
            setNewPosition(positionable, x, y, area);
        } else {
            logNotAllowedResult(allowed);
        }
        Lock.releaseLock();
        sleep();
    }

    private void logStep(Positionable positionable) {
        if (positionable instanceof Loader) {
            logger.info("moving {} on one step", this.name().toLowerCase());
        }
    }

    private void setNewPosition(Positionable positionable, int x, int y, WorkingArea area) {
        Position position = area.getPosition(x, y);
        position.setPositionable(positionable);
        positionable.setPosition(position);
    }

    private void clearCurrentPosition(Positionable positionable) {
        positionable.getPosition().setPositionable(null);
    }

    protected boolean reachVerticalBound(int steps, Positionable positionable, WorkingArea area) {
        long target = positionable.getX() + steps;
        boolean reached = target < 0 || target >= area.getLength();
        logReachBoundsResult(reached, VERTICAL);
        return reached;
    }

    protected boolean reachHorizontalBound(int steps, Positionable positionable, WorkingArea area) {
        long target = positionable.getY() + steps;
        boolean reached = target < 0 || target >= area.getWidth();
        logReachBoundsResult(reached, HORIZONTAL);
        return reached;
    }

    private void logReachBoundsResult(boolean reached, String type) {
        if (reached) {
            logger.info("not allowed to move {}. reached {} bounds", this.name().toLowerCase(), type);
        }
    }

    private void logNotAllowedResult(boolean allowed) {
        if (!allowed) {
            logger.info("not allowed to move {}.", this.name().toLowerCase());
        }
    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
