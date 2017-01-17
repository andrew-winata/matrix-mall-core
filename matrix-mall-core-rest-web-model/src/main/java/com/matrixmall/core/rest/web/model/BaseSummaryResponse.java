package com.matrixmall.core.rest.web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BaseSummaryResponse<T extends Serializable> extends BaseResponse {
  private static final long serialVersionUID = 2570365482630459729L;
  private List<T> content = new ArrayList<>();
  private PagingResponse pageMetaData = new PagingResponse();

  public BaseSummaryResponse(List<T> content, PagingResponse pageMetaData, String requestId) {
    super(null, null, true, requestId);
    this.content = content;
    this.pageMetaData = pageMetaData;
  }

  public BaseSummaryResponse(String errorMessage, String errorCode, boolean success,
      List<T> content, PagingResponse pageMetaData, String requestId) {
    super(errorMessage, errorCode, success, requestId);
    this.content = content;
    this.pageMetaData = pageMetaData;
  }

  public BaseSummaryResponse(String errorMessage, String errorCode, boolean success,
      String requestId) {
    super(errorMessage, errorCode, success, requestId);
  }

  public List<T> getContent() {
    return content;
  }

  public void setContent(List<T> content) {
    this.content = content;
  }

  public PagingResponse getPageMetaData() {
    return pageMetaData;
  }

  public void setPageMetaData(PagingResponse pageMetaData) {
    this.pageMetaData = pageMetaData;
  }

  @Override
  public String toString() {
    return "BaseSummaryResponse [content=" + content + ", pageMetaData=" + pageMetaData + "]";
  }
}
