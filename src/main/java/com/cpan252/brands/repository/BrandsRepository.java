package com.cpan252.brands.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cpan252.brands.model.Brands;
import com.cpan252.brands.model.Brands.BNames;

public interface BrandsRepository extends CrudRepository<Brands, Long> {
    List<Brands> findByBrandNamesAndYearOfCreation(BNames bname, int yearOfCreation);
}