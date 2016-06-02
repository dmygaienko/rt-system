package com.mygaienko.rt_system.interpreter.rule;

import com.mygaienko.rt_system.model.Loader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by enda1n on 22.05.2016.
 */
public class PutDownBoxRule extends AbstractRule {

    private static final Logger logger = LoggerFactory.getLogger(PutDownBoxRule.class);
    private static final String REGEX = "^put down";
    private static final Pattern PATTERN = Pattern.compile(REGEX);

    private static final String EXAMPLE = "put down";
    private static final String NAME = "put down";

    private final Loader loader;

    public PutDownBoxRule(Loader loader) {
        this.loader = loader;
    }

    @Override
    public void process(String msg) {
        Matcher matcher = PATTERN.matcher(msg);
        if (matcher.matches()) {
            logger.info("put down command is applied");
            loader.putDownBox();
        }
    }

    @Override
    public String getName() {
        return EXAMPLE;
    }

    @Override
    public String getExample() {
        return NAME;
    }

    @Override
    public boolean isSimilar(String msg) {
        return msg.trim().startsWith("p") && msg.contains("d");
    }

    @Override
    public Pattern getPattern() {
        return PATTERN;
    }
}
