package com.github.gukovprod.shell;

import com.github.gukovprod.webclients.TinkoffService;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@RequiredArgsConstructor
public class Commands {

    private final TinkoffService tinkoffService;
    @ShellMethod(value = "Prints a list of all possible quotes", key = {"token"})
    public void check(String name) {
        tinkoffService.getInstrumentByName(name).forEach(p->
                System.out.println(p.getInstrumentId() + " " + p.getName() + " " + p.getType()));

    }

    @ShellMethod
    public void candle(String id){
        tinkoffService.getCandles(id);
    }
    @ShellMethod(key = {"last-price"})
    public void lastPrice(String id){
        tinkoffService.getLastPrice(id);
    }


}
