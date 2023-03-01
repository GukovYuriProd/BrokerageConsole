package com.github.gukovprod.commands;

import java.util.ArrayList;
import java.util.List;

public class CommandFabric {
    private static final List<Command> commands = new ArrayList<>(){{
        add(new HelpCommand());
        add(new CheckCommand());
        add(new TradeCommand());
        add(new SetCommand());
    }};

    public Command getCommandByName(String name){
        return  commands.stream().filter(p->p.getName().equals(name)).findFirst().orElseThrow();
    }
    protected static List<Command> getCommands(){
        return commands;
    }
}
