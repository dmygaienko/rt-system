package com.mygaienko.rt_system.interpreter.rule;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by dmygaenko on 02/06/2016.
 */
public abstract class AbstractRule implements Rule {

    private static final Logger logger = LoggerFactory.getLogger(AbstractRule.class);

    @Override
    public boolean isApplied(String msg) {
        boolean applied = getPattern().matcher(msg).matches();
        if (!applied && isSimilar(msg)) {
            logDifference(msg);
        }
        return applied;
    }

    @Override
    public void logDifference(String msg) {
        logger.info("{} command should be like '{}'. the difference started from {} is: '{}'",
                getName(),
                getExample(),
                StringUtils.indexOf(getExample(), msg),
                StringUtils.difference(getExample(), msg));
    }
}
