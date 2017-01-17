package com.matrixmall.core.rest.web.validator;

import com.matrixmall.core.commons.exception.ApplicationException;
import com.matrixmall.core.rest.web.model.user.CreateUserRequest;
import com.matrixmall.core.rest.web.model.user.UpdateUserRequest;

public interface UserRequestValidator {
  void validateCreateUserRequest(CreateUserRequest request) throws ApplicationException;
  
  void validateUpdateUserRequest(UpdateUserRequest request) throws ApplicationException;
}
