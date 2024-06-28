package com.userservice.services;

import java.util.List;

import com.userservice.entity.User;

public interface UserService {
	User saveUser(User user);
	List<User> getAllUser();
	User getUser(String userId);
	
	void deleteUser(String userId);
	User updateUser(User user);

}
