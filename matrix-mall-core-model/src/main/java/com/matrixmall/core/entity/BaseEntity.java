package com.matrixmall.core.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {
  private static final long serialVersionUID = -268174216746584848L;

  @Column(name = "created_date")
  private Date createdDate;

  @Column(name = "created_by")
  private String createdBy;

  @Column(name = "updated_date")
  private Date updatedDate;

  @Column(name = "updated_by")
  private String updatedBy;

  @Version
  @Column(name = "optlock")
  private Long version;

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public Date getUpdatedDate() {
    return updatedDate;
  }

  public void setUpdatedDate(Date updatedDate) {
    this.updatedDate = updatedDate;
  }

  public String getUpdatedBy() {
    return updatedBy;
  }

  public void setUpdatedBy(String updatedBy) {
    this.updatedBy = updatedBy;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }
}
