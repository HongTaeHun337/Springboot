package com.test.java.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.java.entity.Tag;

public interface TagRepository extends JpaRepository<Tag, Long>{

}
