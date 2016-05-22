package com.mygaienko.rt_system.interpreter.rule;

import com.mygaienko.rt_system.model.Loader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * Created by enda1n on 22.05.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class MoveRuleTest {
    
    @Mock
    private Loader loader;
    
    @Test
    public void testIsApplied1() throws Exception {
        MoveRule rule = new MoveRule(loader);
        assertTrue(rule.isApplied("move 1"));
    }

    @Test
    public void testIsAppliedWithoutDigit() throws Exception {
        MoveRule rule = new MoveRule(loader);
        assertFalse(rule.isApplied("move"));
    }

    @Test
    public void testIsApplied11() throws Exception {
        MoveRule rule = new MoveRule(loader);
        assertTrue(rule.isApplied("move 11"));
    }

    @Test
    public void testIsAppliedNotACommand() throws Exception {
        MoveRule rule = new MoveRule(loader);
        assertFalse(rule.isApplied("xxx"));
    }

    @Test
    public void testIsAppliedNotAtTheBeginning() throws Exception {
        MoveRule rule = new MoveRule(loader);
        assertFalse(rule.isApplied("test move 1"));
    }

    @Test
    public void testProcess() throws Exception {
        MoveRule rule = new MoveRule(loader);
        rule.process("move 11");
    }
}