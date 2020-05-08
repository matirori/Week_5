package com.rohraff.currencyapp;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
public class CurrencyService {

    private int counter = 1;

    public CurrencyService() {
    }

    private Currency getCurrency(String currencyName) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://api.exchangeratesapi.io/latest?base="+ currencyName, Currency.class);
    }

    public String compare(UserCurrency userCurrency) {
        String response = "Nie udana inicjalizacja";
        Currency trueCurrency = getCurrency(userCurrency.getCurrencyName());
        Double trueValue = BigDecimal.valueOf(trueCurrency.getRates().getPLN())
                .setScale(2, BigDecimal.ROUND_HALF_DOWN)
                .doubleValue();
        Double userValue = userCurrency.getExchangeRate();
        if(trueValue.equals(userValue)) {
            response = "Brawo, podana została poprawna wartość za " + counter + " razem";
            counter = 1;
        } else  if(trueValue < userValue){
            counter++;
            response =  "Za dużo";
        } else if(trueValue > userValue) {
            counter++;
            response =  "Za Mało";
        }
        return response;
    }
}
