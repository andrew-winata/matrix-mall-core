package com.matrixmall.core.rest.web.model;

public class BaseResponse extends BaseRest {
  private static final long serialVersionUID = 3866687601312733979L;
  private String errorMessage;
  private String errorCode;
  private boolean success;

  public BaseResponse() {}

  /**
   * for success response
   *
   * @param requestId
   */
  public BaseResponse(String requestId) {
    super(requestId);
    this.errorMessage = null;
    this.errorCode = null;
    this.success = true;
  }

  public BaseResponse(String errorMessage, String errorCode, boolean success, String requestId) {
    super(requestId);
    this.errorMessage = errorMessage;
    this.errorCode = errorCode;
    this.success = success;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public String getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  @Override
  public String toString() {
    return "BaseResponse [errorMessage=" + errorMessage + ", errorCode=" + errorCode + ", success="
        + success + "]";
  }
}
