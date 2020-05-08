package com.rohraff.currencyapp;

public class UserCurrency {

    private String currencyName;
    private double exchangeRate;

    public UserCurrency(String currencyName, double exchangeRate) {
        this.currencyName = currencyName;
        this.exchangeRate = exchangeRate;
    }

    public UserCurrency() {
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    @Override
    public String toString() {
        return "UserCurrency{" +
                "currencyName='" + currencyName + '\'' +
                ", exchangeRate=" + exchangeRate +
                '}';
    }
}
