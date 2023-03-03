package com.github.gukovprod.webclients;

import com.github.gukovprod.dto.tinkoff.Instrument;
import lombok.Getter;
import ru.tinkoff.piapi.contract.v1.CandleInterval;
import ru.tinkoff.piapi.core.InvestApi;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class TinkoffService{
    private final InvestApi investApi;
    public TinkoffService(String token, boolean isSandbox) {
        if(isSandbox){

        investApi = InvestApi.createSandbox(token);
        } else {
            investApi = InvestApi.create(token);
        }
    }


    public List<Instrument> getInstrumentByName(String name){
        var s = investApi.getInstrumentsService().findInstrumentSync(name);
        return s
                .stream()
                .map(p-> new Instrument(p.getName(), p.getFigi(), p.getInstrumentType()))
                .collect(Collectors.toList());
    }

    public void getCandles (String instrumentId){
        var s = investApi.getMarketDataService().getCandlesSync(instrumentId, Instant.now().minus(1, ChronoUnit.HOURS), Instant.now(),
                CandleInterval.CANDLE_INTERVAL_HOUR );
        s.forEach(p->
                System.out.println(p.toString()));
    }

    public void getLastPrice (String instrumentId){
        var s = investApi.getMarketDataService().getLastPricesSync(List.of(instrumentId));
        s.forEach(p->
                System.out.println(p.toString()));
    }

}
