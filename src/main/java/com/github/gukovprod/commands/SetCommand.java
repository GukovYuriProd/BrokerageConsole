package com.github.gukovprod.commands;

public class SetCommand implements Command{
    private static final String COMMAND_NAME = "SET";

    @Override
    public void execute(String[] args) {

    }

    @Override
    public String getName() {return COMMAND_NAME;}

    @Override
    public String getShortDescription() {
        return "";
    }

    @Override
    public String getFullDescription() {
        return "";
    }
}
