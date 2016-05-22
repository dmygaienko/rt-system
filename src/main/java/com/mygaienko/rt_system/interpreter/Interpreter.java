package com.mygaienko.rt_system.interpreter;

import com.mygaienko.rt_system.interpreter.rule.Rule;
import com.mygaienko.rt_system.model.Loader;

import java.util.List;

/**
 *
 * Created by dmygaenko on 20/05/2016.
 */
public class Interpreter {

    private static final String COMMA = "\\.";
    private final Loader loader;

    private List<Rule> rules;

    public Interpreter(Loader loader, List<Rule> rules) {
        this.loader = loader;
        this.rules = rules;
    }

    /**
     * Commands:
     *      move forward on * steps
     *      turn on
     *      put up box
     *      put down box
     */
    public void interpet(String msg) {
        String[] commands = msg.split(COMMA);
        for (String command : commands) {
            for (Rule rule : rules) {
                if (rule.isApplied(command)) {
                    rule.process(msg);
                }
            }
        }
    }
}
