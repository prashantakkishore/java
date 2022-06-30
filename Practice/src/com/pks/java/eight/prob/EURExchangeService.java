package com.pks.java.eight.prob;

import java.math.BigDecimal;
import java.util.Optional;

public class EURExchangeService implements ExchangeService{
    @Override
    public Optional<BigDecimal> rate(String currency) {
        return Optional.of(BigDecimal.valueOf(1L));
//        switch (currency){
//            case "one":
//                return Optional.of(BigDecimal.valueOf(1L));
//            case "two":
//                return Optional.of(BigDecimal.valueOf(2L));
//            case "three":
//                return Optional.of(BigDecimal.valueOf(3L));
//            case "four":
//                return Optional.of(BigDecimal.valueOf(4L));
//            case "five":
//                return Optional.of(BigDecimal.valueOf(5L));
//            case "six":
//                return Optional.of(BigDecimal.valueOf(6L));
//            case "seven":
//                return Optional.of(BigDecimal.valueOf(-7L));
//            default:
//                return Optional.of(BigDecimal.valueOf(10L));
//
//        }
    }
}
