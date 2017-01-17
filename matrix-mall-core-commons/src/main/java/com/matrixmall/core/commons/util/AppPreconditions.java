package com.matrixmall.core.commons.util;

import com.google.common.base.Preconditions;
import com.matrixmall.core.commons.constant.ErrorCategory;
import com.matrixmall.core.commons.exception.ApplicationException;

public final class AppPreconditions {
  
  private AppPreconditions() {
    throw new UnsupportedOperationException("must not be instantiated");
  }
  
  public static void checkArgument(boolean expression, String errorMessage) throws ApplicationException{
    try {
      Preconditions.checkArgument(expression, errorMessage);
    } catch (IllegalArgumentException e) {
      throw new ApplicationException(ErrorCategory.VALIDATION, errorMessage, e);
    }
  }
  
}
