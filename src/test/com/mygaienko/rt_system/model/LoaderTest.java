package com.mygaienko.rt_system.model;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by enda1n on 21.05.2016.
 */
public class LoaderTest {

    @Test
    public void testTurnOn90() throws Exception {
        Loader loader = new Loader(null);
        loader.setDirection(DirectionEnum.DOWN);
        loader.turnOn(90);
        assertEquals(DirectionEnum.LEFT, loader.getDirection());
    }

    @Test
    public void testTurnOn180() throws Exception {
        Loader loader = new Loader(null);
        loader.setDirection(DirectionEnum.DOWN);
        loader.turnOn(180);
        assertEquals(DirectionEnum.UP, loader.getDirection());
    }

    @Test
    public void testTurnOn270() throws Exception {
        Loader loader = new Loader(null);
        loader.setDirection(DirectionEnum.DOWN);
        loader.turnOn(270);
        assertEquals(DirectionEnum.RIGHT, loader.getDirection());
    }

    @Test
    public void testTurnOn360() throws Exception {
        Loader loader = new Loader(null);
        loader.setDirection(DirectionEnum.DOWN);
        loader.turnOn(360);
        assertEquals(DirectionEnum.DOWN, loader.getDirection());
    }

    @Test
    public void testTurnOn450() throws Exception {
        Loader loader = new Loader(null);
        loader.setDirection(DirectionEnum.DOWN);
        loader.turnOn(450);
        assertEquals(DirectionEnum.LEFT, loader.getDirection());
    }

    @Test
    public void putUpTurnOnPutDownBox() throws Exception {
        Loader loader = new Loader(new Position(1, 1), new WorkingArea(3, 3), DirectionEnum.DOWN);
        Box box = new Box(new Position(1, 2));
        loader.putUpBox(box);
        loader.turnOn(90);
        loader.putDownBox();
        assertEquals(box.getX(), 0);
        assertEquals(box.getY(), 1);
    }

    @Test
    public void putUpPutDownBox() throws Exception {
        Loader loader = new Loader(new Position(1, 1), new WorkingArea(3, 3), DirectionEnum.DOWN);
        Box box = new Box(new Position(1, 2));
        loader.putUpBox(box);
        loader.putDownBox();
        assertEquals(box.getX(), 1);
        assertEquals(box.getY(), 2);
    }
}