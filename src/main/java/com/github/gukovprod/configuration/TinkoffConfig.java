package com.github.gukovprod.configuration;

import com.github.gukovprod.webclients.TinkoffService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class TinkoffConfig {

    @Bean
    public TinkoffService abstractWebClient(
            @Value("${tinkoff.token}") String token,
            @Value("${tinkoff.sandbox.enabled:false}") Boolean isSandBox
    ){
        return new TinkoffService(token,isSandBox);
    }
}
