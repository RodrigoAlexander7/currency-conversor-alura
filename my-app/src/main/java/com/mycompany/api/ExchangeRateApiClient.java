package com.mycompany.api;

import com.google.gson.Gson;
import com.mycompany.api.dto.ExchangeRateResponse;
import com.mycompany.domain.CurrencyRate;
import com.mycompany.util.HttpClientUtil;

public class ExchangeRateApiClient{
    private final Gson gson = new Gson();

    public CurrencyRate getCurrencyRate(String from, String to){
        String json = null;
        try {
            json = HttpClientUtil.fetchPairData(from, to).body();
        } catch (Exception e) {
            System.err.println(e);
        }        
        ExchangeRateResponse response = gson.fromJson(json, ExchangeRateResponse.class);
        
        if (!"success".equals(response.getResult())) {
            throw new RuntimeException("Error al obtener tipo de cambio");
        }

        return new CurrencyRate(
            response.getBaseCode(),
            response.getTargetCode(),
            response.getConversionRate()
        ); 
    }
}
