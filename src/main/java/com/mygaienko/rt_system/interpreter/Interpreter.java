package com.mygaienko.rt_system.interpreter;

import com.mygaienko.rt_system.interpreter.rule.*;
import com.mygaienko.rt_system.model.Box;
import com.mygaienko.rt_system.model.DirectedState;
import com.mygaienko.rt_system.model.Loader;
import com.mygaienko.rt_system.model.WorkingArea;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by dmygaenko on 20/05/2016.
 */
public class Interpreter {

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
            String trimmed = command.trim();
            for (Rule rule : rules) {
                if (rule.isApplied(trimmed)) {
                    rule.process(trimmed);
                    break;
                }
            }
        }
    }
}
