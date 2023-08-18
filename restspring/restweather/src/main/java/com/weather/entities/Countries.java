package com.weather.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor

public class Countries {
/*
    private String iso2;
    private String iso3;
    private String country;
*/

    private long id;
    private String date;
    private String commune_nom;
    private String commune;
    private String commune_nom_com_1;
    private String commune_nom_com_2;
    private String commune_nom_com_3;
    private String indice;
    private String valeur;
    private String couleur;
    private String type;

    private List<SousIndice> sous_indice;
}
