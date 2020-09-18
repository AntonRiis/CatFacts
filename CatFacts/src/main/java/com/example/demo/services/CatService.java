package com.example.demo.services;

import com.example.demo.models.CatFact;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

public class CatService {

    public String serviceCat() throws IOException {
        URL catURL = new URL("https://cat-fact.herokuapp.com/facts/random");

        BufferedReader inputFromCatURL = new BufferedReader(new InputStreamReader(catURL.openStream()));

        CatFact data = new Gson().fromJson(inputFromCatURL, CatFact.class);

        inputFromCatURL.close();

        return data.toString();

    }

    public static String tenFactsSorted() throws IOException {

        ArrayList<CatFact> CFactList = new ArrayList<>(10);

        for (int i = 1; i <= 10; i++) {
            URL catURL = new URL("https://cat-fact.herokuapp.com/facts/random");
            BufferedReader catURLinput = new BufferedReader(new InputStreamReader(catURL.openStream()));
            CatFact data = new Gson().fromJson(catURLinput, CatFact.class);
            catURLinput.close();

            CFactList.add(data);
        }
        Collections.sort(CFactList);
        return CFactList.toString();


    }

    public String factContains(char c, int n) throws IOException {
        URL catURL = new URL("https://cat-fact.herokuapp.com/facts/random");
        BufferedReader catURLinput = new BufferedReader(new InputStreamReader(catURL.openStream()));
        CatFact data = new Gson().fromJson(catURLinput, CatFact.class);
        catURLinput.close();

        int charCount = 0;

        for (int i = 0; i < data.getText().length(); i++) {
            if (data.getText().charAt(i) == c) {
                charCount++;
            }
        }
        if (charCount == n) {
            return data.toString();
        }
        return "Ingen Cat Facts indeholder denne karakter '" + c + "', " + n + " antal gange." + "<br>" + "Prøv igen";



        }
    }