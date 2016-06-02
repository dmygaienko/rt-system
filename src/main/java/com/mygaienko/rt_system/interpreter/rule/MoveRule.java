package com.mygaienko.rt_system.interpreter.rule;

import com.mygaienko.rt_system.model.Loader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by enda1n on 22.05.2016.
 */
public class MoveRule extends AbstractRule {

    private static final Logger logger = LoggerFactory.getLogger(MoveRule.class);
    private static final String REGEX = "(^move\\s)(\\d+)";
    private static final Pattern PATTERN = Pattern.compile(REGEX);

    private static final String EXAMPLE = "move 1";
    private static final String NAME = "move";

    private final Loader loader;

    public MoveRule(Loader loader) {
        this.loader = loader;
    }

    @Override
    public void process(String msg) {
        Matcher matcher = PATTERN.matcher(msg);
        if (matcher.matches()) {
            logger.info("move command is applied");
            String arg = matcher.toMatchResult().group(2);

            loader.moveForward(Integer.valueOf(arg));
        }
    }

    @Override
    public boolean isSimilar(String msg) {
        return msg.trim().startsWith("m");
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
    public Pattern getPattern() {
        return PATTERN;
    }
}
