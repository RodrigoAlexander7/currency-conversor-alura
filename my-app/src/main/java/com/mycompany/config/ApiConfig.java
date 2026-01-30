package com.mycompany.config;

import io.github.cdimascio.dotenv.Dotenv;

public class ApiConfig{
    Dotenv dotenv = Dotenv.load();
    public final String API_KEY = dotenv.get("EXCHANGE_RATE_API") ;
    public final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/";
}