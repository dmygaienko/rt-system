package com.mygaienko.rt_system.interpreter;

import com.mygaienko.rt_system.command.Command;

import java.util.Map;

/**
 * Created by dmygaenko on 20/05/2016.
 */
public class Interpreter {

    private Map<CommandEnum, Command> commands;

    public Interpreter(Map commands) {
        this.commands = commands;
    }

    public void interpet() {
        commands.get("");
    }
}
