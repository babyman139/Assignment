package com.cpan252.brands.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class BrandsPool {
    private List<Brands> brands;

    public BrandsPool() {
        this.brands = new ArrayList<>();
    }

    public void add(Brands brands) {
        this.brands.add(brands);
    }
}