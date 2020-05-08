package com.rohraff.currencyapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/currency")
public class CurrencyController {

    private String status = "Wprowadź aktualny kurs wybranej waluty uwzględniając 2 miejsca po przecinku";
    private CurrencyService currencyService;

    @Autowired
    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping
    public String getInfo(Model model) {
        model.addAttribute("userCurrency", new UserCurrency());
        model.addAttribute("status", getStatus());
        return "index";
    }

    @GetMapping("/choose")
    public String get(@ModelAttribute UserCurrency userCurrency) {
        setStatus( currencyService.compare(userCurrency));
        return "redirect:/currency";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
