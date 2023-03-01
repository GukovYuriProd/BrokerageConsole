package com.github.gukovprod;

import com.github.gukovprod.commands.CommandFabric;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Application {
    public static void main (String[] args){
        while (true) {
            CallConsole();
        }
    }

    public static void CallConsole (){
        CommandFabric CommandRouter = new CommandFabric();
        Scanner consoleReader = new Scanner(System.in);
        System.out.print("(bc)>");
        String command = consoleReader.nextLine().toUpperCase();
        String[] commandParts = command.split(" ");
        String[] args = new String[commandParts.length-1];
        System.arraycopy(commandParts, 1, args, 0, commandParts.length-1);
        try{
            CommandRouter.getCommandByName(commandParts[0]).execute(args);
        } catch (NoSuchElementException ex) {
            System.out.println("Command \"" + command + "\" does not exist");
        }
    }
}