package com.weather.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataResponseDto {
/*    private String msg;
    private boolean error;
    private List<Countries> data;*/

    private Long count;
    private String next;
    private String previous;
    private List<Countries> results;
}
