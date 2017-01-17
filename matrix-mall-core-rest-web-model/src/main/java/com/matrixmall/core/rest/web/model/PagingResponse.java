package com.matrixmall.core.rest.web.model;

import java.io.Serializable;

public class PagingResponse implements Serializable {
  private static final long serialVersionUID = 4149521121570607578L;
  private long pageSize = 0;
  private long pageNumber = 0;
  private long totalRecords = 0;

  public PagingResponse() {}

  public PagingResponse(long pageSize, long pageNumber, long totalRecords) {
    this.pageSize = pageSize;
    this.pageNumber = pageNumber;
    this.totalRecords = totalRecords;
  }

  public long getPageSize() {
    return pageSize;
  }

  public void setPageSize(long pageSize) {
    this.pageSize = pageSize;
  }

  public long getPageNumber() {
    return pageNumber;
  }

  public void setPageNumber(long pageNumber) {
    this.pageNumber = pageNumber;
  }

  public long getTotalRecords() {
    return totalRecords;
  }

  public void setTotalRecords(long totalRecords) {
    this.totalRecords = totalRecords;
  }

  @Override
  public String toString() {
    return "PagingResponse [pageSize=" + pageSize + ", pageNumber=" + pageNumber
        + ", totalRecords=" + totalRecords + "]";
  }
}
