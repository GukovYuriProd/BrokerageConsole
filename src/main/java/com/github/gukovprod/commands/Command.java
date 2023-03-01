package com.github.gukovprod.commands;

public interface Command {
    void execute(String[] args);

    String getName();

    String getShortDescription();

    String getFullDescription();
}
