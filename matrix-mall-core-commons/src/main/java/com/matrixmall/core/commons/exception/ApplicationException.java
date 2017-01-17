package com.matrixmall.core.commons.exception;

import com.matrixmall.core.commons.constant.ErrorCategory;

public class ApplicationException extends Exception{
  private static final long serialVersionUID = -4926845019192517468L;
  private final ErrorCategory errorCategory;

  public ApplicationException() {
    // no-op
    super(ErrorCategory.UNSPECIFIED.getMessage());
    this.errorCategory = ErrorCategory.UNSPECIFIED;
  }

  public ApplicationException(ErrorCategory errorCategory) {
    super(errorCategory.getMessage());
    this.errorCategory = errorCategory;
  }

  public ApplicationException(ErrorCategory errorCategory, String errorMessage) {
    super(errorCategory.getMessage() + errorMessage);
    this.errorCategory = errorCategory;
  }

  public ApplicationException(ErrorCategory errorCategory, String errorMessage,
      Throwable throwable) {
    super(errorCategory.getMessage() + errorMessage, throwable);
    this.errorCategory = errorCategory;
  }

  public ErrorCategory getErrorCategory() {
    return this.errorCategory;
  }
}
