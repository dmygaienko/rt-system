package com.mygaienko.rt_system.interpreter.rule;

/**
 * Created by enda1n on 22.05.2016.
 */
public interface Rule {

    boolean isApplied(String msg);

    public void process(String msg);
}
