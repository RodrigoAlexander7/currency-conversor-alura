package com.mycompany.app;
import java.net.http.HttpResponse;

import com.mycompany.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("jai");
        
        HttpClientUtil client = new HttpClientUtil();
        try {
            HttpResponse res = client.fetchPairData("USD", "PEN");
            System.out.println(res.body());
        } catch (Exception e) {
            System.err.println(e);
        }

    }
}
