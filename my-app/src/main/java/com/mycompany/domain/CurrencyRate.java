package com.mycompany.domain;

public class CurrencyRate {

    private final String from;
    private final String to;
    private final double rate;

    public CurrencyRate(String from, String to, double rate) {
        this.from = from;
        this.to = to;
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }

}