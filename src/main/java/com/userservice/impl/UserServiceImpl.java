package com.userservice.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.userservice.entity.Rating;
import com.userservice.entity.User;
import com.userservice.repository.UserRespository;
import com.userservice.services.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class UserServiceImpl implements UserService{

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private final UserRespository userRepos;
	@Override
	public User saveUser(User user) {
		String randomId = UUID.randomUUID().toString();
		user.setUserId(randomId);
		return userRepos.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepos.findAll();
	}

	@Override
	public User getUser(String userId) {
		User user =  userRepos.findById(userId).orElseThrow(()->new RuntimeException("Id not found"+userId));
		List<Rating> getRatings = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), List.class);
	    user.setRatings(getRatings);
	    return user;
	}

	@Override
	public void deleteUser(String userId) {
		userRepos.deleteById(userId);
		
	}

	@Override
	public User updateUser(User user) {
		userRepos.findById(user.getUserId()).orElseThrow(()->  new RuntimeException("Id not found"));
	    return userRepos.save(user);
	}

}
