package com.matrixmall.core.rest.web.model.user;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponse implements Serializable {
  private static final long serialVersionUID = 2339888966598455080L;
  private String id;
  private String username;
  private Integer type;
  private String email;
  private String name;
  private boolean delete;
  private Date createdDate;
  private String createdBy;
  private Date updatedDate;
  private String updatedBy;
  @JsonProperty(access = Access.READ_ONLY)
  private Long version;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isDelete() {
    return delete;
  }

  public void setDelete(boolean delete) {
    this.delete = delete;
  }

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
