package com.blive.test1.controller;

import java.util.List;

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
import com.blive.test1.model.User;
import com.blive.test1.service.UserService;

@Controller
@ComponentScan(basePackageClasses = UserController.class)
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModuleRepository moduleRepository;
	
	@GetMapping("/")
	public String viewMenu() {
		return "index";
	}


	
	//display list of users
	@GetMapping("/listUsers")
	public String viewHomePage(Model model) {
         model.addAttribute("listUsers", userService.getAllUsers());
		
        return "listUsers";
    }
	
	@GetMapping("/showNewUserForm")
    public String showNewEmployeeForm(Model model) {
        // create model attribute to bind form data
        User user= new User();
        model.addAttribute("user", user);
        List<Module> listModules = moduleRepository.findAll();
        model.addAttribute("listModules", listModules);
        return "new_user";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        // save user to database
        userService.saveUser(user);
        return "redirect:/listUsers";
    }

    @GetMapping("/showFormForUpdate/{iduser}")
    public String showFormForUpdate(@PathVariable(value = "iduser") long iduser, Model model) {

        // get user from the service
        User user = userService.getUserById(iduser);

        // set user as a model attribute to pre-populate the form
        model.addAttribute("user", user);
        List<Module> listModules = moduleRepository.findAll();
        model.addAttribute("listModules", listModules);
        return "update_user";
    }

    @GetMapping("/deleteUser/{iduser}")
    public String deleteUser(@PathVariable(value = "iduser") long iduser) {

        // call delete user method 
        this.userService.deleteUserById(iduser);
        return "redirect:/listUsers";
    }

	
}
