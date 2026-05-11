package com.test.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.java.entity.Member;

public interface MemberRepositroy extends JpaRepository<Member, String>{

}
