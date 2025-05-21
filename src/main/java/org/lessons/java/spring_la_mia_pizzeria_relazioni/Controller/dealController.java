package org.lessons.java.spring_la_mia_pizzeria_relazioni.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/deals")
public class dealController {
    @GetMapping
    public String test() {
        return "deals/index";
    }

    
}
