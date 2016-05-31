package com.mygaienko.rt_system.interpreter.rule;

import com.mygaienko.rt_system.model.Loader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by enda1n on 22.05.2016.
 */
public class MoveRule implements Rule{

    private static final Logger logger = LoggerFactory.getLogger(MoveRule.class);
    private static final String MOVE_REGEX = "(^move\\s)(\\d+)";
    private static final Pattern PATTERN = Pattern.compile(MOVE_REGEX);

    private final Loader loader;

    public MoveRule(Loader loader) {
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
            logger.info("move command is applied");
            String arg = matcher.toMatchResult().group(2);

            loader.moveForward(Integer.valueOf(arg));
        }
    }
}
