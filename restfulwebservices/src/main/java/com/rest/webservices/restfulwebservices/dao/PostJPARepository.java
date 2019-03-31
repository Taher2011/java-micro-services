package com.rest.webservices.restfulwebservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.webservices.restfulwebservices.bean.Post;

@Repository
public interface PostJPARepository extends JpaRepository<Post, Integer> {

}
