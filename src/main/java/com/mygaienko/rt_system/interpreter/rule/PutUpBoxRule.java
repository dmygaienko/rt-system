package com.mygaienko.rt_system.interpreter.rule;

import com.mygaienko.rt_system.model.Loader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by enda1n on 22.05.2016.
 */
public class PutUpBoxRule implements Rule{

    private static final String PUT_UP_REGEX = "^put up";
    private static final Pattern PATTERN = Pattern.compile(PUT_UP_REGEX);

    private final Loader loader;

    public PutUpBoxRule(Loader loader) {
        this.loader = loader;
    }

    @Override
    public boolean isApplied(String msg) {
        return PATTERN.matcher(msg).matches();
    }

    @Override
    public void process(String msg) {
        Matcher matcher = PATTERN.matcher(msg);
        if (matcher.matches()) {
            loader.putUpBox();
        }
    }
}
