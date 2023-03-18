package com.cpan252.brands.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Brands {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    private BNames brandNames;
    @Min(1001)
    private int price;
    @Max(2021)
    private int yearOfCreation;
    

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