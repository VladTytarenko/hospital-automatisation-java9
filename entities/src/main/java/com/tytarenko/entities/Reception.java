package com.tytarenko.entities;

import java.sql.Date;

public class Reception {

    private long id;
    private String doctorPassport;
    private String patientPassport;
    private Date date;
    private long price;

    public Reception() {
    }

    public Reception(String doctorPassport, String patientPassport, Date date, long price) {
        this.doctorPassport = doctorPassport;
        this.patientPassport = patientPassport;
        this.date = date;
        this.price = price;
    }

    public Reception(long id, String doctorPassport, String patientPassport, Date date, long price) {
        this.id = id;
        this.doctorPassport = doctorPassport;
        this.patientPassport = patientPassport;
        this.date = date;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDoctorPassport() {
        return doctorPassport;
    }

    public void setDoctorPassport(String doctorPassport) {
        this.doctorPassport = doctorPassport;
    }

    public String getPatientPassport() {
        return patientPassport;
    }

    public void setPatientPassport(String patientPassport) {
        this.patientPassport = patientPassport;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
