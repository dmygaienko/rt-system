package com.mygaienko.rt_system.interpreter.rule;

import java.util.regex.Pattern;

/**
 * Created by enda1n on 22.05.2016.
 */
public interface Rule {

    boolean isApplied(String msg);

    boolean isSimilar(String msg);

    void process(String msg);

    String getName();

    String getExample();

    Pattern getPattern();

    void logDifference(String msg);
}
