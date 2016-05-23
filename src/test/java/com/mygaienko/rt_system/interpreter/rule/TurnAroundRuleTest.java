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
    public void testIsApplied90() throws Exception {
        assertTrue(rule.isApplied("turn around 90"));
    }

    @Test
    public void testIsApplied180() throws Exception {
        assertTrue(rule.isApplied("turn around 180"));
    }

    @Test
    public void testIsAppliedWrong() throws Exception {
        assertFalse(rule.isApplied("turn around"));
    }

    @Test
    public void testProcess() throws Exception {

    }
}