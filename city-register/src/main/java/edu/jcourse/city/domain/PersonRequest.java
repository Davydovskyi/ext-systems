package edu.jcourse.city.domain;

import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.time.LocalDate;

public class PersonRequest {
    private String surName;
    private String givenName;
    private String patronymic;
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate dateOfBirth;
    private Integer streetCode;
    private String building;
    private String extension;
    private String apartment;

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getStreetCode() {
        return streetCode;
    }

    public void setStreetCode(Integer streetCode) {
        this.streetCode = streetCode;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(getClass().getSimpleName());
        sb.append("{surName='").append(surName).append('\'');
        sb.append(", givenName='").append(givenName).append('\'');
        sb.append(", patronymic='").append(patronymic).append('\'');
        sb.append(", dateOfBirth=").append(dateOfBirth);
        sb.append(", streetCode=").append(streetCode);
        sb.append(", building='").append(building).append('\'');
        sb.append(", extension='").append(extension).append('\'');
        sb.append(", apartment='").append(apartment).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
