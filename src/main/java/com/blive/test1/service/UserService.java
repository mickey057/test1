package com.blive.test1.service;

import java.util.List;

import com.blive.test1.model.User;

public interface UserService {
	
	 List <User> getAllUsers();
	    void saveUser(User user);
	    User getUserById(long iduser);
	    void deleteUserById(long iduser);

}
