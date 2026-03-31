package com.example.client.model.dto;

import java.util.Objects;
public class CustomerDto {
    private int id;
    private String name;
    private double salary;
    private String adharcard_number;
    private String pancard_number;
    private int loan_amount;

    public CustomerDto(int id, String name, double salary, String adharcard_number, String pancard_number, int loan_amount) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.adharcard_number = adharcard_number;
        this.pancard_number = pancard_number;
        this.loan_amount = loan_amount;
    }

    public CustomerDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getAdharcard_number() {
        return adharcard_number;
    }

    public void setAdharcard_number(String adharcard_number) {
        this.adharcard_number = adharcard_number;
    }

    public String getPancard_number() {
        return pancard_number;
    }

    public void setPancard_number(String pancard_number) {
        this.pancard_number = pancard_number;
    }

    public int getLoan_amount() {
        return loan_amount;
    }

    public void setLoan_amount(int loan_amount) {
        this.loan_amount = loan_amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDto that = (CustomerDto) o;
        return id == that.id && Double.compare(that.salary, salary) == 0 && loan_amount == that.loan_amount && Objects.equals(name, that.name) && Objects.equals(adharcard_number, that.adharcard_number) && Objects.equals(pancard_number, that.pancard_number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, salary, adharcard_number, pancard_number, loan_amount);
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", adharcard_number='" + adharcard_number + '\'' +
                ", pancard_number='" + pancard_number + '\'' +
                ", loan_amount=" + loan_amount +
                '}';
    }
}
