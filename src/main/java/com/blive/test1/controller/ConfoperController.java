package com.blive.test1.controller;

import java.util.List;

import com.blive.test1.dao.ConfoperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.blive.test1.dao.ModuleRepository;
import com.blive.test1.model.Module;
import com.blive.test1.model.Confoper;


@Controller
@ComponentScan(basePackageClasses = ConfoperController.class)
public class ConfoperController {

    @Autowired
    private ConfoperRepository confoperRepository;


    @GetMapping("/listConfoper")
    public String viewConfoperPage(Model model) {
        List<Confoper> listConfopers = confoperRepository.findAll() ;
        model.addAttribute("listConfopers", listConfopers);

        return "listConfoper";
    }



    @GetMapping("/Confoper/new")
    public String showNewConfoperForm(Model model) {
        // create model attribute to bind form data
        Confoper confoper = new Confoper();
        model.addAttribute("confoper", confoper);
        return "NewConfoper";
    }

    @PostMapping("/confoper/save")
    public String saveConfoper(@ModelAttribute("confoper") Confoper confoper) {
        // save user to database
        confoperRepository.save(confoper);
        return "redirect:/listConfoper";
    }

    @GetMapping("/confoper/update/{idconfoper}")
    public String showFormForUpdateConfoper(@PathVariable(value = "idconfoper") long idconfoper, Model model) {


        Confoper confoper= confoperRepository.findById(idconfoper).get();


        model.addAttribute("confoper", confoper);
        return "NewConfoper";
    }
    @GetMapping("/confoper/delete/{idconfoper}")
    public String deleteConfoper(@PathVariable(value = "idconfoper") long idconfoper, Model model) {

        // call delete Module method
        confoperRepository.deleteById(idconfoper);
        return "redirect:/listConfoper";
    }
}

