package com.matrixmall.core.service.validator;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.matrixmall.core.commons.constant.AppConstant;
import com.matrixmall.core.commons.exception.ApplicationException;
import com.matrixmall.core.commons.util.AppPreconditions;
import com.matrixmall.core.entity.User;

@Component
public class UserServiceValidatorBean implements UserServiceValidator {
  
  private static final String WRONG_MODE = "Wrong mode for create/update";
  private static final String EMPTY_REQUEST = "Request cannot be empty";
  private static final String EMPTY_USERNAME = "Username cannot be empty";
  private static final String EMPTY_EMAIL = "Email cannot be empty";
  private static final String EMPTY_NAME = "Name cannot be empty";
  private static final String INVALID_EMAIL_FORMAT = "Invalid email format";
  
  private void validateMandatoryFields(User toBeSavedUser) throws ApplicationException{
    AppPreconditions.checkArgument(toBeSavedUser != null, EMPTY_REQUEST);
    AppPreconditions.checkArgument(StringUtils.isNotBlank(toBeSavedUser.getUsername()), EMPTY_USERNAME);
    AppPreconditions.checkArgument(StringUtils.isNotBlank(toBeSavedUser.getEmail()), EMPTY_EMAIL);
    AppPreconditions.checkArgument(Pattern.matches(AppConstant.EMAIL_PATTERN, toBeSavedUser.getEmail()), INVALID_EMAIL_FORMAT + ":" + toBeSavedUser.getEmail());
    AppPreconditions.checkArgument(StringUtils.isNotBlank(toBeSavedUser.getName()), EMPTY_NAME);
  }

  @Override
  public void validateSaveUser(User toBeSavedUser, boolean isCreate) throws ApplicationException {
    if (isCreate) {
      AppPreconditions.checkArgument(StringUtils.isEmpty(toBeSavedUser.getId()), WRONG_MODE);
    }
    validateMandatoryFields(toBeSavedUser);
  }

}
