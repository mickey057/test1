package com.blive.test1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.blive.test1.model.Module;
import com.blive.test1.service.ModuleService;

@Controller
@ComponentScan(basePackageClasses = ModuleController.class)
public class ModuleController {
	@Autowired
	private ModuleService moduleService;
	//display list of Modules
	    
	    
		@GetMapping("/viewModule")
		public String viewHomePage(Model model) {
	         model.addAttribute("listModules", moduleService.getAllModules());
	        return "module";
	    }
		
		@GetMapping("/showNewModuleForm")
	    public String showNewModuleForm(Model model) {
	        // create model attribute to bind form data
			Module module= new Module();
	        model.addAttribute("module", module);
	        return "newModule";
	    }

	    @PostMapping("/saveModule")
	    public String saveModule(@ModelAttribute("module") Module module) {
	        // save module to database
	        moduleService.saveModule(module);
	        return "redirect:/viewModule";
	    }

	    @GetMapping("/showFormForUpdateModule/{idmodule}")
	    public String showFormForUpdate(@PathVariable(value = "idmodule") long idmodule, Model model) {

	        // get Module from the service
	        Module module= moduleService.getModuleById(idmodule);

	        // set user as a model attribute to pre-populate the form
	        model.addAttribute("module", module);
	        return "updateModule";
	    }

	    @GetMapping("/deleteModule/{idmodule}")
	    public String deleteModule(@PathVariable(value = "idmodule") long idmodule) {

	        // call delete Module method 
	        this.moduleService.deleteModuleById(idmodule);
	        return "redirect:/ViewModule";
	    }


}
