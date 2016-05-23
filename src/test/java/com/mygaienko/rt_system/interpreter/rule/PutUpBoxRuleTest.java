package com.mygaienko.rt_system.interpreter.rule;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dmygaenko on 23/05/2016.
 */
public class PutUpBoxRuleTest extends AbstractRuleTest {

    private PutUpBoxRule rule;

    @Before
    public void setUp() throws Exception {
        rule = new PutUpBoxRule(loader);
    }

    @Test
    public void testIsApplied() throws Exception {
        assertTrue(rule.isApplied("put up"));
    }

    @Test
    public void testIsAppliedWithDigits() throws Exception {
        assertFalse(rule.isApplied("put up 12"));
    }

    @Test
    public void testProcess() throws Exception {

    }
}