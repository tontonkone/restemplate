package com.weather.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SousIndice {
    private String polluant_name;
    private String polluant;
    private String indice;
    private String valeur;
    private String couleur;

}
