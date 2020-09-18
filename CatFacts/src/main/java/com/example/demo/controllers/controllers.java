package com.example.demo.controllers;

import com.example.demo.services.CatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;

@Controller
public class controllers {
    CatService service = new CatService();

    @GetMapping("/")
    @ResponseBody
    public String frontPage() {
        return "Vær hilset kammerat. Denne application giver dig fakta om katte, som du har glemt i morgen. God fornøjelse.";
    }

    @GetMapping("/getSingle")
    @ResponseBody
    public String singleFact() {
        return service.toString();
    }

    @GetMapping("/getTen")
    @ResponseBody
    public String tenFact() {
        ArrayList<String> catFactList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            catFactList.add(service.toString());
        }
        return catFactList.toString();
    }

    @GetMapping("/getTenSortedByDate")
    @ResponseBody
    public String tenFactsSorted() throws IOException {
        return service.tenFactsSorted();
    }

    @GetMapping("/contains")
    @ResponseBody
    public String tryContains(@RequestParam char character, int amount) throws IOException {
        return service.factContains(character, amount);
    }
}
