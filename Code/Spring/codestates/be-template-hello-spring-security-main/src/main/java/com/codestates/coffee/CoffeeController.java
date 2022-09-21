package com.codestates.coffee;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/coffees")
public class CoffeeController {
    @GetMapping
    public String getCoffees(Model model) {
        return "coffee";
    }
}
