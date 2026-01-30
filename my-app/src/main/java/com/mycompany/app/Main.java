package com.mycompany.app;

import java.util.Scanner;

import com.mycompany.api.ExchangeRateApiClient;
import com.mycompany.domain.CurrencyRate;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] codes = {"USD","EUR","PEN","CLP","ARS","COP","BOB","UYU","PYG"};
        String[] names = {"Dólar (USD)", "Euro (EUR)", "Sol peruano (PEN)", "Peso chileno (CLP)", "Peso argentino (ARS)", "Peso colombiano (COP)", "Boliviano (BOB)", "Peso uruguayo (UYU)", "Guaraní paraguayo (PYG)"};

        ExchangeRateApiClient api = new ExchangeRateApiClient();

        while (true) {
            System.out.println("=== Conversor de monedas ===");
            for (int i = 0; i < codes.length; i++) {
                System.out.printf("%d) %s%n", i + 1, names[i]);
            }
            System.out.println("0) Salir");

            System.out.print("Seleccione moneda origen (número): ");
            int from = -1;
            try { from = Integer.parseInt(sc.nextLine()); } catch (Exception e) { from = -1; }
            if (from == 0) break;
            if (from < 1 || from > codes.length) { System.out.println("Selección inválida.\n"); continue; }

            System.out.print("Seleccione moneda destino (número): ");
            int to = -1;
            try { to = Integer.parseInt(sc.nextLine()); } catch (Exception e) { to = -1; }
            if (to == 0) break;
            if (to < 1 || to > codes.length) { System.out.println("Selección inválida.\n"); continue; }

            System.out.print("Ingrese monto a convertir: ");
            double amount = 0;
            try { amount = Double.parseDouble(sc.nextLine()); } catch (Exception e) { System.out.println("Monto inválido.\n"); continue; }

            String fromCode = codes[from - 1];
            String toCode = codes[to - 1];

            try {
                CurrencyRate rate = api.getCurrencyRate(fromCode, toCode);
                double converted = amount * rate.getRate();
                System.out.printf("%.2f %s = %.2f %s%n%n", amount, fromCode, converted, toCode);
            } catch (Exception e) {
                System.err.println("Error al obtener tipo de cambio: " + e.getMessage() + "\n");
            }
        }

        sc.close();
    }
}
