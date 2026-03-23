package com.neerad.SpringSecurity.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Students {
    private int id;
    private String name;
    private int marks;
}
