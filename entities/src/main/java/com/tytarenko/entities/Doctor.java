package com.tytarenko.entities;

import java.sql.Date;


public class Doctor {

    private String passport;
    private String surname;
    private String name;
    private String patronymic;
    private String password;
    private Date birthdate;
    private int specialization;
    private int experience;
    private String position;
    private String degree;

    public Doctor() {
    }

    public Doctor(String surname,
                  String name, String patronymic, String passport,
                  String password, Date birthdate,
                  int specialization, int experience,
                  String position, String degree) {
        this.passport = passport;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.password = password;
        this.birthdate = birthdate;
        this.specialization = specialization;
        this.experience = experience;
        this.position = position;
        this.degree = degree;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public int getSpecialization() {
        return specialization;
    }

    public void setSpecialization(int specialization) {
        this.specialization = specialization;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
}
