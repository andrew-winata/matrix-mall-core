package com.matrixmall.core.rest.web.validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.matrixmall.core.commons.exception.ApplicationException;
import com.matrixmall.core.commons.util.AppPreconditions;
import com.matrixmall.core.rest.web.model.user.CreateUserRequest;
import com.matrixmall.core.rest.web.model.user.UpdateUserRequest;

@Component
public class UserRequestValidatorBean implements UserRequestValidator{
  
  private static final String BLANK_REQUEST = "Request object cannot be empty";
  private static final String BLANK_USERNAME = "Username cannot be empty"; 
  private static final String BLANK_NAME = "Name cannot be empty";
  private static final String BLANK_EMAIL = "Email cannot be empty";
  private static final String BLANK_ID = "ID cannot be empty";

  @Override
  public void validateCreateUserRequest(CreateUserRequest request) throws ApplicationException {
     AppPreconditions.checkArgument(request != null, BLANK_REQUEST);
     AppPreconditions.checkArgument(StringUtils.isNotBlank(request.getUsername()), BLANK_USERNAME);
     AppPreconditions.checkArgument(StringUtils.isNotBlank(request.getName()), BLANK_NAME);
     AppPreconditions.checkArgument(StringUtils.isNotBlank(request.getEmail()), BLANK_EMAIL);
  }

  @Override
  public void validateUpdateUserRequest(UpdateUserRequest request) throws ApplicationException {
    AppPreconditions.checkArgument(request != null, BLANK_REQUEST);
    AppPreconditions.checkArgument(StringUtils.isNotBlank(request.getId()), BLANK_ID);
    AppPreconditions.checkArgument(StringUtils.isNotBlank(request.getName()), BLANK_NAME);
    AppPreconditions.checkArgument(StringUtils.isNotBlank(request.getEmail()), BLANK_EMAIL);
  }

}
