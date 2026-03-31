package com.example.client.thirdparty;

import jakarta.persistence.Column;

import java.util.Objects;

public class AdharDto {
    private int id;
    private String name;
    private String adharcard_number;
    public AdharDto(int id, String name, String adharcard_number) {
        this.id = id;
        this.name = name;
        this.adharcard_number = adharcard_number;
    }

    public AdharDto() {
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

    public String getAdharcard_number() {
        return adharcard_number;
    }

    public void setAdharcard_number(String adharcard_number) {
        this.adharcard_number = adharcard_number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdharDto adharDto = (AdharDto) o;
        return id == adharDto.id && Objects.equals(name, adharDto.name) && Objects.equals(adharcard_number, adharDto.adharcard_number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, adharcard_number);
    }

    @Override
    public String toString() {
        return "AdharDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", adharcard_number='" + adharcard_number + '\'' +
                '}';
    }
}
