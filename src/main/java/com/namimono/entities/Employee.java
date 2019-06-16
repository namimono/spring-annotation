package com.namimono.entities;


import java.sql.Date;

public class Employee {
  private Integer empId;
  private String empName;
  private String job;
  private java.sql.Date hireDate;
  private Integer salary;
  private Integer deptId;

  public Employee() {
  }


  @Override
  public String toString() {
    return "Employee{" +
            "empId=" + empId +
            ", empName='" + empName + '\'' +
            ", job='" + job + '\'' +
            ", hireDate=" + hireDate +
            ", salary=" + salary +
            ", deptId=" + deptId +
            '}';
  }

  public Employee(Integer empId, String empName, String job, Date hireDate, Integer salary, Integer deptId) {
    this.empId = empId;
    this.empName = empName;
    this.job = job;
    this.hireDate = hireDate;
    this.salary = salary;
    this.deptId = deptId;
  }

  public Integer getEmpId() {
    return empId;
  }

  public void setEmpId(Integer empId) {
    this.empId = empId;
  }

  public String getEmpName() {
    return empName;
  }

  public void setEmpName(String empName) {
    this.empName = empName;
  }

  public String getJob() {
    return job;
  }

  public void setJob(String job) {
    this.job = job;
  }

  public Date getHireDate() {
    return hireDate;
  }

  public void setHireDate(Date hireDate) {
    this.hireDate = hireDate;
  }

  public Integer getSalary() {
    return salary;
  }

  public void setSalary(Integer salary) {
    this.salary = salary;
  }

  public Integer getDeptId() {
    return deptId;
  }

  public void setDeptId(Integer deptId) {
    this.deptId = deptId;
  }
}
