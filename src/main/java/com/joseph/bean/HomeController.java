package com.joseph.bean;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String homePage() {
        return "songform";
    }

    @GetMapping("/number")
    public String loadFormPage2(Model model) {
        model.addAttribute("number", new Number());
        return "addnumber";
    }

    @PostMapping("/number")
    public String loadFromPage2(@ModelAttribute Number number,
                               Model  model) {
        model.addAttribute("number", number);
        return  "confirmnumber";
    }

    @GetMapping("/songform")
    public String loadFormPage(Model model) {
        model.addAttribute("song", new Song());
        return "songform";
    }

    @PostMapping("/songform")
    public String loadFromPage(@ModelAttribute Song song,
                               Model  model) {
        ///model.addAttribute("song", song);
        return  "confirmsong";
    }

    @GetMapping("/movieform")
    public String movieForm(Model model) {
        model.addAttribute("movie", new Movie());
        return "movieform";
    }

    @PostMapping("/movieform")
    public String movieForm(@Valid Movie movie, BindingResult result) {
        //model.addAttribute("movie", movie);
        if (result.hasErrors()) {
            return "movieform";
        }
        return  "movieconfirm";
    }

    @GetMapping("/carform")
    public String carForm(Model model) {
        model.addAttribute("car", new Car());
        return "carform";
    }

    @PostMapping("/carform")
    public String carForm(@Valid Car car, BindingResult result) {
        if (result.hasErrors()) {
            return "carform";
        }
        return "carconfirm";
    }
}
