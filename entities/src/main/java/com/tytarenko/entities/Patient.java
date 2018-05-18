package com.tytarenko.entities;

import java.sql.Date;


public class Patient {

    private String passport;
    private String surname;
    private String name;
    private String patronymic;
    private String address;
    private String email;
    private Date birthdate;
    private Date registrationDate;
    private String invalidity;
    private String insuranceCompany;
    private String insuranceType;
    private String insuranceNumber;

    public Patient() {
    }

    public Patient(String passport, String surname, String name, String patronymic, String address, String email, Date birthdate, Date registrationDate, String invalidity, String insuranceCompany, String insuranceType, String insuranceNumber) {
        this.passport = passport;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.address = address;
        this.email = email;
        this.birthdate = birthdate;
        this.registrationDate = registrationDate;
        this.invalidity = invalidity;
        this.insuranceCompany = insuranceCompany;
        this.insuranceType = insuranceType;
        this.insuranceNumber = insuranceNumber;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getInvalidity() {
        return invalidity;
    }

    public void setInvalidity(String invalidity) {
        this.invalidity = invalidity;
    }

    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }
}
