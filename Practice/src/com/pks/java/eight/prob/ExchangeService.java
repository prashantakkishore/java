package com.pks.java.eight.prob;

import java.math.BigDecimal;
import java.util.Optional;

public interface ExchangeService {

    Optional<BigDecimal> rate (String currency);
}
