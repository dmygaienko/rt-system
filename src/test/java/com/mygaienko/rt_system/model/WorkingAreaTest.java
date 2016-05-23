package com.mygaienko.rt_system.model;

import com.mygaienko.rt_system.model.alarm.Alarm;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by enda1n on 21.05.2016.
 */
public class WorkingAreaTest {

    @Test
    public void isAlarm() {
        WorkingArea workingArea = new WorkingArea(3, 3);
        workingArea.setAlarm(Alarm.FLOOD);

        assertTrue(workingArea.isAlarm());
        assertFalse(workingArea.isAllowed(1, 1));
    }

    @Test
    public void test() {
        WorkingArea workingArea = new WorkingArea();
        workingArea.setAlarm(Alarm.FLOOD);

        assertTrue(workingArea.isAlarm());
        assertFalse(workingArea.isAllowed(1, 1));
    }
}