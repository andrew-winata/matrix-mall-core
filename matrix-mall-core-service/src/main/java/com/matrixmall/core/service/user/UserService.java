package com.matrixmall.core.service.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.matrixmall.core.entity.User;

public interface UserService {
  Page<User> findAll(Pageable pageable);

  User findByUsername(String username);
  
  User findById(String id);
  
  User create(User user) throws Exception;
  
  User update(User user) throws Exception;
  
  void delete(String id) throws Exception;
}
