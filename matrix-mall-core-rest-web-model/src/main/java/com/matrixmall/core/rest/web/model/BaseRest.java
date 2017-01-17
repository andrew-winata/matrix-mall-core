package com.matrixmall.core.rest.web.model;

import java.io.Serializable;

public class BaseRest implements Serializable {
  private static final long serialVersionUID = -747895157618582601L;
  private String requestId;

  public BaseRest() {}

  public BaseRest(String requestId) {
    this.requestId = requestId;
  }

  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }
}
