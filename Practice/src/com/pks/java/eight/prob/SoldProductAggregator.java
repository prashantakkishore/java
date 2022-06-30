package com.pks.java.eight.prob;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SoldProductAggregator {

    private final EURExchangeService exchangeService;

    public SoldProductAggregator(EURExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    SoldProductsAggregate aggregate(Stream<SoldProduct> products) {

        if (products == null)
            products = Stream.empty();

        // simple sold product
        List<SimpleSoldProduct> sspList = products.map(p -> {
            Optional<BigDecimal> conRate =  this.exchangeService.rate(p.getCurrency());
            if (conRate == null || !conRate.isPresent() || conRate.get().signum() < 0 ){
                // dont count product
                return null;
            }
            SimpleSoldProduct ssp = new SimpleSoldProduct(p.getName(), conRate.get().multiply(p.getPrice()));
            return ssp;
        }).filter(x -> x != null).collect(Collectors.toList());
        // total
        BigDecimal sum = sspList.stream().map(x -> x.getPrice()).reduce(BigDecimal.ZERO, BigDecimal::add);
        // sold pro aggregate
        SoldProductsAggregate spa = new SoldProductsAggregate(sspList, sum);
        return spa;
    }

    public static void main(String[] args) {
        SoldProductAggregator aggregator = new SoldProductAggregator(new EURExchangeService());
        SoldProduct p1 = new SoldProduct("one", BigDecimal.valueOf(0.2312), "one");
        SoldProduct p2 = new SoldProduct("two", BigDecimal.valueOf(0.0325), "two");
        SoldProduct p3 = new SoldProduct("three", BigDecimal.valueOf(0.1350), "three");
        SoldProduct p4 = new SoldProduct("four", BigDecimal.valueOf(0.0136), "four");
        SoldProduct p5 = new SoldProduct("five", BigDecimal.valueOf(0.0084), "five");
        SoldProduct p6 = new SoldProduct("six", BigDecimal.valueOf(1), "six");
        SoldProduct p7 = new SoldProduct("seven", BigDecimal.valueOf(0.0385), "seven");
        SoldProduct p8 = new SoldProduct("eight", BigDecimal.valueOf(0.0030), "seven");
        SoldProduct p9 = new SoldProduct("nine", BigDecimal.valueOf(0.5105), "seven");
        SoldProduct p10 = new SoldProduct("ten", BigDecimal.valueOf(0.2146), "seven");

        Stream<SoldProduct> products = Arrays.stream(new SoldProduct[]{p1, p2, p3, p4, p5, p6, p7, p8, p9, p10});



        SoldProductsAggregate spa = aggregator.aggregate(products);
        System.out.println(spa.getProducts());
        System.out.println(spa.getTotal());


        // bigdecimal check

        double d1 = 1000.0;
        double d2 = 0.001;
        System.out.println(d1 + d2);
    }
}
