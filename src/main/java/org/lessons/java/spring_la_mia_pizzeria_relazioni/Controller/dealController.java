package org.lessons.java.spring_la_mia_pizzeria_relazioni.Controller;

import org.lessons.java.spring_la_mia_pizzeria_relazioni.model.Deal;
import org.lessons.java.spring_la_mia_pizzeria_relazioni.repository.DealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/deals")
public class DealController {

    @Autowired
    private DealRepository repo;

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("deal") Deal newDeal,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "deals/create";
        }
        repo.save(newDeal);
        return "redirect:/pizzas";
    }

}
