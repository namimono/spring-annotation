package com.namimono.entities;


public class Usersmessage {

  private long id;
  private String nickname;
  private String password;
  private String gender;
  private String hobby;
  private String address;
  private String phone;
  private long role;
  private double balanced;
  private String headurl;

  public Usersmessage(String nickname, String password) {
    this.nickname = nickname;
    this.password = password;
  }

  @Override
  public String toString() {
    return "Usersmessage{" +
            "id=" + id +
            ", nickname='" + nickname + '\'' +
            ", password='" + password + '\'' +
            ", gender='" + gender + '\'' +
            ", hobby='" + hobby + '\'' +
            ", address='" + address + '\'' +
            ", phone='" + phone + '\'' +
            ", role=" + role +
            ", balanced=" + balanced +
            ", headurl='" + headurl + '\'' +
            '}';
  }

  public Usersmessage() {
  }

  public Usersmessage(long id, String nickname, String password) {
    this.id = id;
    this.nickname = nickname;
    this.password = password;
  }

  public Usersmessage(long id, String nickname, String password, String gender, String hobby, String address, String phone, long role, double balanced, String headurl) {
    this.id = id;
    this.nickname = nickname;
    this.password = password;
    this.gender = gender;
    this.hobby = hobby;
    this.address = address;
    this.phone = phone;
    this.role = role;
    this.balanced = balanced;
    this.headurl = headurl;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }


  public String getHobby() {
    return hobby;
  }

  public void setHobby(String hobby) {
    this.hobby = hobby;
  }


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public long getRole() {
    return role;
  }

  public void setRole(long role) {
    this.role = role;
  }


  public double getBalanced() {
    return balanced;
  }

  public void setBalanced(double balanced) {
    this.balanced = balanced;
  }


  public String getHeadurl() {
    return headurl;
  }

  public void setHeadurl(String headurl) {
    this.headurl = headurl;
  }

}
