package com.matrixmall.core.rest.web.converter;

import com.matrixmall.core.entity.User;
import com.matrixmall.core.rest.web.model.user.CreateUserRequest;
import com.matrixmall.core.rest.web.model.user.UpdateUserRequest;

public interface UserRequestConverter {
	User convertCreateUserRequest(CreateUserRequest request);
	
	User convertUpdateUserRequest(UpdateUserRequest request);
}
