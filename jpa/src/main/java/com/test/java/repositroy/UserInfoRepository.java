package com.test.java.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.java.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, String>{

}
