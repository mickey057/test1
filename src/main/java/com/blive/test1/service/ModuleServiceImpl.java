package com.blive.test1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blive.test1.dao.ModuleRepository;
import com.blive.test1.model.Module;

@Service
public class ModuleServiceImpl implements ModuleService {

@Autowired
private ModuleRepository moduleRepository;

@Override
public List<Module> getAllModules(){
	return  moduleRepository.findAll();
}

@Override
public void saveModule(Module module) {
	this.moduleRepository.save(module);
}

@Override
public Module getModuleById(long idmodule) {
	
	Optional <Module> optional = moduleRepository.findById(idmodule);
    Module module= null;
    if (optional.isPresent()) {
        module = optional.get();
    } else {
        throw new RuntimeException(" User not found for id :: " + idmodule);
    }
    return module;
	
}

@Override
public void deleteModuleById(long idmodule) {
	this.moduleRepository.deleteById(idmodule);
}


}
