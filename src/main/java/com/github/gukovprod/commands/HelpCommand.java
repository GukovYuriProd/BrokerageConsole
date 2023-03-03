package com.github.gukovprod.commands;

import java.util.Objects;

public class HelpCommand implements Command {

    private static final String COMMAND_NAME = "HELP";

    @Override
    public void execute(String[] args) {
        if ((args.length > 1)&&(Objects.equals(args[1], "FULL"))) {
            System.out.println(CommandFabric.getCommands().stream().filter(p->
                    p.getName().equals(args[0])).findFirst().orElseThrow().getFullDescription());
        } else if (args.length == 1) {
            System.out.println(CommandFabric.getCommands().stream().filter(p->
                p.getName().equals(args[0])).findFirst().orElseThrow().getShortDescription());
        } else {
            System.out.println(CommandFabric.getCommands().stream().filter(p->
                    p.getName().equals("HELP")).findFirst().orElseThrow().getShortDescription());
        }
    }

    @Override
    public String getName() {
        return COMMAND_NAME;
    }

    @Override
    public String getFullDescription() {
        return "Realy? Close the app, you too stupid for this shit";
    }

    @Override
    public String getShortDescription() {
        //TODO Sent full list of commands
        return "Prints a list of all possible commands";
    }
}
