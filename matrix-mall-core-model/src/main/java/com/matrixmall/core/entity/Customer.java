package com.matrixmall.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "mtx_customer")
@PrimaryKeyJoinColumn(name = "id")
public class Customer extends User {
  private static final long serialVersionUID = -1778886815453708146L;

  @Column(name = "address")
  private String address;
  @Column(name = "phone_number")
  private String phoneNumber;

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

}
