package edu.miu.cs489.lab1b.model;

import java.time.LocalDate;

public class Employee {
    private Long employeeId;
    private String firstName;
    private String lastName;
    private LocalDate employementDate;
    private double yearlySalary;

    private PensionPlan pensionPlan;
    public Employee(Long employeeId, String firstName, String lastName, LocalDate employementDate, double yearlySalary, PensionPlan pensionPlan) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employementDate = employementDate;
        this.yearlySalary = yearlySalary;
        this.pensionPlan=pensionPlan;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getEmployementDate() {
        return employementDate;
    }

    public void setEmployementDate(LocalDate employementDate) {
        this.employementDate = employementDate;
    }

    public double getYearlySalary() {
        return yearlySalary;
    }

    public void setYearlySalary(double yearlySalary) {
        this.yearlySalary = yearlySalary;
    }

    public PensionPlan getPensionPlan() {
        return pensionPlan;
    }

    public void setPensionPlan(PensionPlan pensionPlan) {
        this.pensionPlan = pensionPlan;
    }

    public String toJSONString() {
        return pensionPlan==null?String.format("\t{ \"employeeId\":%d, \"firstName\":\"%s\", \"lastName\":\"%s\", \"employementDate\":\"%s\", \"yearlySalary\":%.2f, \"pensionPlan\":null }",
                employeeId, firstName, lastName, employementDate, yearlySalary):String.format("\t{ \"employeeId\":%d, \"firstName\":\"%s\", \"lastName\":\"%s\", \"employementDate\":\"%s\", \"yearlySalary\":%.2f, \"pensionPlan\": %s } }",
                employeeId, firstName, lastName, employementDate, yearlySalary, pensionPlan.toJSONString());
    }

}
