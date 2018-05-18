package com.tytarenko.entities;

public class Referal {

    private long id;
    private String patient;
    private String doctorFrom;
    private int specialization;

    public Referal() {
    }

    public Referal(String patient, String doctorFrom, int specialization) {
        this.patient = patient;
        this.doctorFrom = doctorFrom;
        this.specialization = specialization;
    }

    public Referal(long id, String patient, String doctorFrom, int specialization) {
        this.id = id;
        this.patient = patient;
        this.doctorFrom = doctorFrom;
        this.specialization = specialization;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getDoctorFrom() {
        return doctorFrom;
    }

    public void setDoctorFrom(String doctorFrom) {
        this.doctorFrom = doctorFrom;
    }

    public int getSpecialization() {
        return specialization;
    }

    public void setSpecialization(int specialization) {
        this.specialization = specialization;
    }
}
