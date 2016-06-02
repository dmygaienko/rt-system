package com.mygaienko.rt_system.interpreter.rule;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by enda1n on 22.05.2016.
 */
public class MoveRuleTest extends AbstractRuleTest {

    private MoveRule rule;

    @Before
    public void setUp() throws Exception {
        rule = new MoveRule(loader);
    }

    @Test
    public void testIsApplied1() throws Exception {
        assertTrue(rule.isApplied("move 1"));
    }

    @Test
    public void testIsApplied1d() throws Exception {
        assertFalse(rule.isApplied("move 1d"));
    }

    @Test
    public void testIsApplied2d() throws Exception {
        assertFalse(rule.isApplied("mve 1d"));
    }


    @Test
    public void testIsAppliedWithoutDigit() throws Exception {
        assertFalse(rule.isApplied("move"));
    }

    @Test
    public void testIsApplied11() throws Exception {
        assertTrue(rule.isApplied("move 11"));
    }

    @Test
    public void testIsAppliedNotACommand() throws Exception {
        assertFalse(rule.isApplied("xxx"));
    }

    @Test
    public void testIsAppliedNotAtTheBeginning() throws Exception {
        assertFalse(rule.isApplied("test move 1"));
    }

    @Test
    public void testProcess() throws Exception {
        rule.process("move 11");
    }
}