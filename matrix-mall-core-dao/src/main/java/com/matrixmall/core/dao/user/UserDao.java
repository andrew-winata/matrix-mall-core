package com.matrixmall.core.dao.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matrixmall.core.entity.User;

public interface UserDao extends JpaRepository<User, String> {
    
	User findByUsername(String username);

}
