package com.matrixmall.core.rest.web.util;

public final class ControllerUtils {
  public static String generateLoggerRequestId(String requestId) {
    return "[REQ_ID:" + requestId + "]";
  }
  
  private ControllerUtils() {}
}
