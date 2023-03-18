package com.cpan252.brands.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cpan252.brands.model.dto.ItemsSearchByBrandYearDto;
import com.cpan252.brands.repository.BrandsRepository;

@Controller
@RequestMapping("/itemlist")
public class ItemListController {
    private BrandsRepository brandsRepository;

    public ItemListController(BrandsRepository brandsRepository) {
        this.brandsRepository = brandsRepository;
    }

    @GetMapping
    public String showItems(Model model) {
        return "itemlist";
    }

    @ModelAttribute
    public void brands(Model model) {
        model.addAttribute("brands", brandsRepository.findAll());
    }

    @ModelAttribute
    public void itemsByBrandYearDto(Model model) {
        model.addAttribute("itemsByBrandYearDto", new ItemsSearchByBrandYearDto());
    }

    @PostMapping
    public String searchItemsByBrandYear(@ModelAttribute ItemsSearchByBrandYearDto itemsByBrandYearDto, Model model) {
        model.addAttribute("brands", brandsRepository.findByBrandNamesAndYearOfCreation(itemsByBrandYearDto.getBrandNames(), itemsByBrandYearDto.getYearOfCreation()));
        return "itemlist";
    }

}