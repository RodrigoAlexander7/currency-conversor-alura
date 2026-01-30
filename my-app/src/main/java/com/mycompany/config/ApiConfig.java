package com.mycompany.config;

import io.github.cdimascio.dotenv.Dotenv;

public class ApiConfig{
    public static final Dotenv dotenv = Dotenv.load();
    public static final String API_KEY = dotenv.get("EXCHANGE_RATE_API") ;
    public static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/";
}