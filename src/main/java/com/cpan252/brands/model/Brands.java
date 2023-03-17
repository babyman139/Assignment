package com.cpan252.brands.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Brands {
    private Long id;
    @NotBlank
    private String name;
    private BNames brandNames;
    @Min(1001)
    private int price;
    @Min(2022)
    private int yOfCreation;
    

    public enum BNames {
        BALENCIAGA("Balenciaga"), STONE_ISLAND("Stone Island"), DIOR("Dior"), GUCCI("Gucci");

        private String title;

        private BNames(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }
}