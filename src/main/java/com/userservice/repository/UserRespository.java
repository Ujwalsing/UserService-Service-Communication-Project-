package com.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userservice.entity.User;

public interface UserRespository extends JpaRepository<User, String>{

}
