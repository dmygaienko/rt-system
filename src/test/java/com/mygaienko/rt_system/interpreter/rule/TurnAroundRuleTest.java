package com.mygaienko.rt_system.interpreter.rule;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dmygaenko on 23/05/2016.
 */
public class TurnAroundRuleTest extends AbstractRuleTest {

    private TurnAroundRule rule;

    @Before
    public void setUp() throws Exception {
        rule = new TurnAroundRule(loader);
    }

    @Test
    public void testIsAppliedUp() throws Exception {
        assertTrue(rule.isApplied("turn up"));
        assertTrue(rule.isApplied("TURN UP"));
    }

    @Test
    public void testIsAppliedDown() throws Exception {
        assertTrue(rule.isApplied("turn down"));
    }

    @Test
    public void testIsAppliedLeft() throws Exception {
        assertTrue(rule.isApplied("turn left"));
    }

    @Test
    public void testIsAppliedRight() throws Exception {
        assertTrue(rule.isApplied("turn right"));
    }


    @Test
    public void testProcessRight() throws Exception {
        rule.process("turn right");
    }
}