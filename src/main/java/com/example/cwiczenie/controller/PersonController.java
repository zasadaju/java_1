package com.example.cwiczenie.controller;

import com.example.cwiczenie.model.Person;
import com.example.cwiczenie.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;

@Controller
    public class PersonController {
    @Autowired
    private PersonRepository PersonRepository;

    @GetMapping("/")
    public String showPage(Model model) {
        model.addAttribute("allPersons", PersonRepository.findAll());
        return "index";
    }

    @PostMapping("/add")
    public String addPerson(@RequestParam String name, Model model) {
        Person newPerson = new Person(name);
        PersonRepository.save(newPerson);
        return "redirect:/";
    }
}