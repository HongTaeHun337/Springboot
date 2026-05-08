package com.test.java.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.java.entity.User;

public interface UserRepository extends JpaRepository<User, String>{

}
