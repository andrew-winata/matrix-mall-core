package com.matrixmall.core.service.validator;

import com.matrixmall.core.commons.exception.ApplicationException;
import com.matrixmall.core.entity.User;

public interface UserServiceValidator {
  void validateSaveUser(User toBeSavedUser, boolean isCreate) throws ApplicationException;
}
