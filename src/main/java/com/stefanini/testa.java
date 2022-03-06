package com.stefanini;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Locale;

public class testa {
    public static void main(String[] args) {
        Month hoje = LocalDate.now().getMonth();
        LocalDate proximoMes = LocalDate.now().plusMonths(1);
        LocalDate segundoMesAFrente = LocalDate.now().plusMonths(2);

        System.out.println(hoje);
        System.out.println(proximoMes);
        System.out.println(segundoMesAFrente);
        
        Locale local = new Locale("pt", "BR");
        DateFormat dateFormat = new SimpleDateFormat("MM", local);

        System.out.println(dateFormat);
    }
}
