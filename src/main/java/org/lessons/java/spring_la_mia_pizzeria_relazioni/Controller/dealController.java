package org.lessons.java.spring_la_mia_pizzeria_relazioni.controller;

import org.lessons.java.spring_la_mia_pizzeria_relazioni.model.Deal;
import org.lessons.java.spring_la_mia_pizzeria_relazioni.repository.DealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/deals")
public class DealController {

    @Autowired
    private DealRepository dealRepository;

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("deal") Deal newDeal,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "deals/create";
        }
        dealRepository.save(newDeal);
        return "redirect:/pizzas";
    }

    @PostMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("deal") Deal deal,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {

            return "deals/create-or-edit";
        }
        model.addAttribute("edit", true);
        dealRepository.save(deal);
        return "redirect:/pizzas";
    }
}
