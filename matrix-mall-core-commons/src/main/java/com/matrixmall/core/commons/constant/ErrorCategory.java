package com.matrixmall.core.commons.constant;

public enum ErrorCategory {
  VALIDATION("Can not process invalid input data "),
  UNSPECIFIED("Uncategorized error ");
  
  private String message;
  
  ErrorCategory(String message) {
    this.message = message;
  }

  public String getCode() {
    return this.name();
  }

  public String getMessage() {
    return this.message + ":";
  }
  
}
