package com.example.webproject.controller;
import com.example.webproject.entity.Supplement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.example.webproject.repository.SupplementRepository;
import com.example.webproject.service.UserActionsService;

import java.util.Optional;

@Slf4j
@Controller
public class SupplementController {
    @Autowired
    private SupplementRepository supplementRepository;
    @Autowired
    private UserActionsService userActionsService;

    public SupplementController() {
    }


    @GetMapping("/list")
    public ModelAndView getAllSupplements() {
        log.info("/list->connection");
        ModelAndView mav = new ModelAndView("list-supplement");
        mav.addObject("supplements", supplementRepository.findAll());
        userActionsService.savelog("Show the list of all supplements");
        return mav;
    }


    @GetMapping("/addNewSupplementForm")
    public ModelAndView addNewSupplementForm() {
        ModelAndView mav = new ModelAndView("add-supplement-form");
        Supplement supplement = new Supplement();
        mav.addObject("supplements", supplement);
        userActionsService.savelog("User creates new supplement record");
        return mav;
    }

    @PostMapping("/saveSupplementForm")
    public String saveSupplement(@ModelAttribute Supplement supplement) {
        supplementRepository.save(supplement);
        userActionsService.savelog("User saves new supplement record");
        return "redirect:/list";
    }

    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Long supplementId) {
        ModelAndView mav = new ModelAndView("add-supplement-form");
        Optional<Supplement> optionalSupplement = supplementRepository.findById(supplementId);
        Supplement supplement = new Supplement();
        if (optionalSupplement.isPresent()) {
            supplement = optionalSupplement.get();
        }
        mav.addObject("supplement", supplement);
        userActionsService.savelog("User views the list of supplements");
        return mav;
    }

    @GetMapping("/deleteSupplement")
    public String deleteSupplement(@RequestParam Long supplementId) {
        supplementRepository.deleteById(supplementId);
        userActionsService.savelog("User deletes the supplement record");
        return "redirect:/list";

    }
}
