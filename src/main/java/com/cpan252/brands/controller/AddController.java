package com.cpan252.brands.controller;

import java.util.EnumSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cpan252.brands.model.Brands;
import com.cpan252.brands.model.Brands.BNames;
import com.cpan252.brands.repository.BrandsRepository;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
@RequestMapping("/add")
public class AddController {

    @Autowired
    private BrandsRepository brandsRepository;

    @GetMapping
    public String add() {
        return "add";
    }

    @ModelAttribute
    public void bnames(Model model) {
        var bnames = EnumSet.allOf(BNames.class);
        model.addAttribute("bnames", bnames);
        log.info("animes converted to string:  {}", bnames);
    }

    @ModelAttribute
    public Brands brands() {
        return Brands
                .builder()
                .build();
    }

    @PostMapping
    public String processBrandsAddition(@Valid Brands brands, BindingResult result) {
        if (result.hasErrors()) {
            return "add";
        }
        log.info("Processing item: {}", brands);
        brandsRepository.save(brands);
        return "redirect:/itemlist";
    }

}