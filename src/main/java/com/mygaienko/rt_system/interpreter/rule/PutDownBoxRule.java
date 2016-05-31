package com.mygaienko.rt_system.interpreter.rule;

import com.mygaienko.rt_system.model.Loader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by enda1n on 22.05.2016.
 */
public class PutDownBoxRule implements Rule{

    private static final Logger logger = LoggerFactory.getLogger(PutDownBoxRule.class);
    private static final String PUT_DOWN_REGEX = "^put down";
    private static final Pattern PATTERN = Pattern.compile(PUT_DOWN_REGEX);

    private final Loader loader;

    public PutDownBoxRule(Loader loader) {
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
            logger.info("put down command is applied");
            loader.putDownBox();
        }
    }
}
