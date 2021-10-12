package com.blive.test1.service;

import java.util.List;

import com.blive.test1.model.Module;

public interface ModuleService {
	
		 List <Module> getAllModules();
		    void saveModule(Module module);
		    Module getModuleById(long idmodule);
		    void deleteModuleById(long idmodule);


}
