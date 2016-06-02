package com.mygaienko.rt_system.interpreter;

import com.mygaienko.rt_system.interpreter.rule.*;
import com.mygaienko.rt_system.model.Box;
import com.mygaienko.rt_system.model.DirectedState;
import com.mygaienko.rt_system.model.Loader;
import com.mygaienko.rt_system.model.WorkingArea;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by dmygaenko on 20/05/2016.
 */
public class Interpreter {
    private static final Logger logger = LoggerFactory.getLogger(Interpreter.class);

    private static final String COMMA = "\\.";

    private List<Rule> rules = new ArrayList<>();

    public Interpreter() {
        Loader loader = initArea();

        rules.add(new MoveRule(loader));
        rules.add(new PutDownBoxRule(loader));
        rules.add(new PutUpBoxRule(loader));
        rules.add(new TurnAroundRule(loader));
    }

    private Loader initArea() {
        WorkingArea area = WorkingArea.getInstance();
        Loader loader = new Loader(area, DirectedState.RIGHT);
        area.setPositionable(loader, 0 , 0);

        area.setPositionable(new Box(), 2, 2);
        area.setPositionable(new Box(), 2, 3);
        return loader;
    }

    public boolean analyze(String text) {
        boolean found = false;

        String[] commands = text.split(COMMA);
        for (String command : commands) {
            String trimmed = command.trim();

            for (Rule rule : rules) {
                if (rule.isApplied(trimmed)) {
                    found = true;
                    break;
                }
            }
        }
        logger.info("commands are analyzed");
        if (!found) {
            logger.info("commands have errors");
        }

        return found;
    }

    /**
     * Commands:
     *      move forward on * steps
     *      turn on
     *      put up box
     *      put down box
     */
    public void interpet(String text) {
        String[] commands = text.split(COMMA);
        for (String command : commands) {
            String trimmed = command.trim();
            for (Rule rule : rules) {
                if (rule.isApplied(trimmed)) {
                    rule.process(trimmed);
                    break;
                }
            }
        }
        logger.info("commands are completed");
    }

    public void handle(String text) {
        if (analyze(text)) {
            interpet(text);
        }
    }
}
