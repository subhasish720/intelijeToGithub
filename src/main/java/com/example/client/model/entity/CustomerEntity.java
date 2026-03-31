package com.example.client.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "client_loan_approval")
public class CustomerEntity {
    @Id
    private int id;
    private String name;
    private double salary;
    @Column(name = "adharcard_number")
    private String adharcard_number;
    @Column(name = "pancard_number")
    private String pancard_number;
    private int loan_amount;
    private boolean flag;

    public CustomerEntity(int id, String name, double salary, String adharcard_number, String pancard_number, int loan_amount, boolean flag) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.adharcard_number = adharcard_number;
        this.pancard_number = pancard_number;
        this.loan_amount = loan_amount;
        this.flag = flag;
    }

    public CustomerEntity() {
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

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerEntity that = (CustomerEntity) o;
        return id == that.id && Double.compare(that.salary, salary) == 0 && loan_amount == that.loan_amount && flag == that.flag && Objects.equals(name, that.name) && Objects.equals(adharcard_number, that.adharcard_number) && Objects.equals(pancard_number, that.pancard_number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, salary, adharcard_number, pancard_number, loan_amount, flag);
    }

    @Override
    public String toString() {
        return "CustomerEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", adharcard_number='" + adharcard_number + '\'' +
                ", pancard_number='" + pancard_number + '\'' +
                ", loan_amount=" + loan_amount +
                ", flag=" + flag +
                '}';
    }
}
