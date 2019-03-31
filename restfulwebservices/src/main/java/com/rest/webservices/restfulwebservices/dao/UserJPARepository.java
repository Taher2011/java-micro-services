package com.rest.webservices.restfulwebservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.webservices.restfulwebservices.bean.User;

@Repository
public interface UserJPARepository extends JpaRepository<User, Integer> {

}
