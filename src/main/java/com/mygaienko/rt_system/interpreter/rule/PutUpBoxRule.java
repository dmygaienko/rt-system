package com.mygaienko.rt_system.interpreter.rule;

import com.mygaienko.rt_system.model.Loader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by enda1n on 22.05.2016.
 */
public class PutUpBoxRule extends AbstractRule{

    private static final Logger logger = LoggerFactory.getLogger(PutDownBoxRule.class);
    private static final String PUT_UP_REGEX = "^put up";
    private static final Pattern PATTERN = Pattern.compile(PUT_UP_REGEX);

    private static final String EXAMPLE = "put up";
    private static final String NAME = "put up";

    private final Loader loader;

    public PutUpBoxRule(Loader loader) {
        this.loader = loader;
    }

    @Override
    public void process(String msg) {
        Matcher matcher = PATTERN.matcher(msg);
        if (matcher.matches()) {
            logger.info("put up command is applied");
            loader.putUpBox();
        }
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getExample() {
        return EXAMPLE;
    }

    @Override
    public boolean isSimilar(String msg) {
        return msg.trim().startsWith("p") && msg.contains("u");
    }

    @Override
    public Pattern getPattern() {
        return PATTERN;
    }
}
