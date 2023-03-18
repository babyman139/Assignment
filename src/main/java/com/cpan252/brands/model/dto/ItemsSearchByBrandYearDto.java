package com.cpan252.brands.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import com.cpan252.brands.model.Brands.BNames;

@Data
@NoArgsConstructor
public class ItemsSearchByBrandYearDto {
    private BNames brandNames;
    private int yearOfCreation;
}
