package com.mygaienko.rt_system.interpreter.rule;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Created by dmygaenko on 23/05/2016.
 */
public class PutDownBoxRuleTest extends AbstractRuleTest {

    private PutDownBoxRule rule;

    @Before
    public void setUp() throws Exception {
        rule = new PutDownBoxRule(loader);
    }

    @Test
    public void testIsApplied() throws Exception {
        assertTrue(rule.isApplied("put down"));
    }

    @Test
    public void testIsAppliedWithDigits() throws Exception {
        assertFalse(rule.isApplied("put down 12"));
    }

    @Test
    public void testProcess() throws Exception {

    }
}