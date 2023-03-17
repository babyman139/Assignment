package com.cpan252.brands.controller;

import java.util.EnumSet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cpan252.brands.model.Brands;
import com.cpan252.brands.model.BrandsPool;
import com.cpan252.brands.model.Brands.BNames;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
@RequestMapping("/add")
@SessionAttributes("brandsPool")
public class AddController {

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

    @ModelAttribute(name = "brandsPool")
    public BrandsPool brandsPool() {
        return new BrandsPool();
    }

    @ModelAttribute
    public Brands brands() {
        return Brands
                .builder()
                .build();
    }

    @PostMapping
    public String processFighterAddition(@Valid Brands brands,
            @ModelAttribute BrandsPool pool, Errors errors) {
        if (errors.hasErrors()) {
            return "add";
        }
        pool.add(brands);
        return "redirect:/add";
    }

}