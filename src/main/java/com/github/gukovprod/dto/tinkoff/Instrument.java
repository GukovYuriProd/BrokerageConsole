package com.github.gukovprod.dto.tinkoff;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Instrument {
    private String name;
    private String instrumentId;

    private String type;
}
