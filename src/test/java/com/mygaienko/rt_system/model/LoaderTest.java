package com.mygaienko.rt_system.model;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by enda1n on 21.05.2016.
 */
public class LoaderTest {

    private WorkingArea area;

    @Before
    public void setUp() throws Exception {
        area = new WorkingArea(3, 3);
    }

    @Test
    public void testTurnOn90() throws Exception {
        Loader loader = new Loader(area, DirectedState.DOWN);
        loader.turnOn("left");
        assertEquals(DirectedState.LEFT, loader.getDirection());
    }

    @Test
    public void testTurnOn180() throws Exception {
        Loader loader = new Loader(area, DirectedState.DOWN);
        loader.turnOn("up");
        assertEquals(DirectedState.UP, loader.getDirection());
    }

    @Test
    public void testTurnOn270() throws Exception {
        Loader loader = new Loader(area, DirectedState.DOWN);
        loader.turnOn("right");
        assertEquals(DirectedState.RIGHT, loader.getDirection());
    }

    @Test
    public void testTurnOn360() throws Exception {
        Loader loader = new Loader(area, DirectedState.DOWN);
        loader.turnOn("down");
        assertEquals(DirectedState.DOWN, loader.getDirection());
    }

    @Test
    public void testTurnOn450() throws Exception {
        Loader loader = new Loader(area, DirectedState.DOWN);
        loader.turnOn("left");
        assertEquals(DirectedState.LEFT, loader.getDirection());
    }

    @Test
    public void putUpTurnOnPutDownBox() throws Exception {
        Loader loader = new Loader(area, DirectedState.DOWN);
        area.setPositionable(loader, 1, 1);

        Box box = new Box();
        area.setPositionable(box, 1, 2);

        loader.putUpBox();
        loader.turnOn("left");
        loader.putDownBox();

        assertEquals(box.getX(), 0);
        assertEquals(box.getY(), 1);
    }

    @Test
    public void putUpPutDownBox() throws Exception {
        Loader loader = new Loader(area, DirectedState.DOWN);
        area.setPositionable(loader, 1, 1);

        Box box = new Box();
        area.setPositionable(box, 1, 2);

        loader.putUpBox();
        loader.putDownBox();

        assertEquals(box.getX(), 1);
        assertEquals(box.getY(), 2);
    }
}