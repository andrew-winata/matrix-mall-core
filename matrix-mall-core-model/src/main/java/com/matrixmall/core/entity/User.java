package com.matrixmall.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "mtx_user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends BaseEntity {
  private static final long serialVersionUID = 2014167827445954268L;

  @Id
  @GeneratedValue(generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid2")
  @Column(name = "id")
  private String id;

  @Column(name = "username", nullable = false, unique = true)
  private String username;

  @Column(name = "password", nullable = false)
  private String password;

  @Column(name = "type", nullable = false)
  private Integer type;

  @Column(name = "email", nullable = false)
  private String email;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "is_delete", nullable = false)
  private boolean delete;

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

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
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
}
