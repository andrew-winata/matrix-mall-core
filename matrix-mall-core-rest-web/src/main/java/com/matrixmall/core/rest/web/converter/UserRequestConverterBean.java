package com.matrixmall.core.rest.web.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.matrixmall.core.entity.User;
import com.matrixmall.core.rest.web.model.user.CreateUserRequest;
import com.matrixmall.core.rest.web.model.user.UpdateUserRequest;
import com.matrixmall.core.service.user.UserService;

@Component
public class UserRequestConverterBean implements UserRequestConverter {
  
  @Autowired
  private UserService userService;

  @Override
  public User convertCreateUserRequest(CreateUserRequest request) {
    User user = new User();
    BeanUtils.copyProperties(request, user);
    return user;
  }

  @Override
  public User convertUpdateUserRequest(UpdateUserRequest request) {
    User savedUser = userService.findById(request.getId());
    BeanUtils.copyProperties(request, savedUser, "id");
    return savedUser;
  }

}
