package com.weather.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.entities.Countries;
import com.weather.entities.DataResponseDto;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class CityController {
    List<Countries> countries = new ArrayList<>();

    @PostConstruct
    public void initialize() {
        getCountryDetails(); // Appel de la méthode pour initialiser la liste des pays au démarrage
    }

    @GetMapping("/cities")
    public List<Countries> getCountryDetails(){
        String url = "https://data.airpl.org/api/v1/indice/commune/";
        RestTemplate template = new RestTemplate();
        Object[] objects = new  Object[]{template.getForObject(url,Object.class)};
        ObjectMapper objectMapper = new ObjectMapper();

        countries =  Arrays.stream(objects).map(o -> objectMapper.convertValue(o, DataResponseDto.class))
                .map(DataResponseDto::getResults)
                .collect(Collectors.toList()).get(0);
        return countries;
    }
    //localhost:8080/commune?code=44028
    @GetMapping("/commune")
    public List<Countries> getCity(@RequestParam String code){
       return countries.stream().filter(e->e.getCommune().equals(code)).collect(Collectors.toList());
    }
}
