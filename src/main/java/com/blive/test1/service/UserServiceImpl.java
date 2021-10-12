package com.blive.test1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blive.test1.dao.UserRepository;
import com.blive.test1.model.User;

@Service
public class UserServiceImpl  implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List <User> getAllUsers(){
		
		return userRepository.findAll();
	}
	
	@Override
	public void saveUser(User user ) {
		this.userRepository.save(user);
	}
	
	@Override
	public User getUserById(long iduser) {
		
		Optional <User> optional = userRepository.findById(iduser);
        User user = null;
        if (optional.isPresent()) {
            user = optional.get();
        } else {
            throw new RuntimeException(" User not found for iduser :: " + iduser);
        }
        return user;
		
	}
	
	@Override
	public void deleteUserById(long iduser) {
		this.userRepository.deleteById(iduser);
	}
	
	
}
