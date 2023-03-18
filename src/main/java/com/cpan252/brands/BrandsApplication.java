package com.cpan252.brands;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cpan252.brands.model.Brands;
import com.cpan252.brands.model.Brands.BNames;
import com.cpan252.brands.repository.BrandsRepository;

@SpringBootApplication
public class BrandsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrandsApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(BrandsRepository repository) {
		return args -> {
			repository.save(Brands.builder()
			.name("Men's Interlocking G loafer")
			.brandNames(BNames.GUCCI)
			.price(1500)
			.yearOfCreation(2021).build());

			repository.save(Brands.builder()
			.name("Cujoh Jolyne Women's Jacket")
			.brandNames(BNames.STONE_ISLAND)
			.price(3500)
			.yearOfCreation(2020).build());

			repository.save(Brands.builder()
			.name("Bat Rectangle Sunglasses")
			.brandNames(BNames.BALENCIAGA)
			.price(1275)
			.yearOfCreation(2021).build());
			
			repository.save(Brands.builder()
			.name("Pop Smoke Bombmer Jacket")
			.brandNames(BNames.DIOR)
			.price(3000)
			.yearOfCreation(2020).build());
		};
	}

}
