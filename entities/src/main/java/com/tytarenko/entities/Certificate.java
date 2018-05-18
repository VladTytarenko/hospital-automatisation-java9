package com.tytarenko.entities;

public class Certificate {

    private long certificateNumber;
    private String certificatName;
    private String passport;

    public Certificate() {
    }

    public Certificate(long certificateNumber, String certificatName, String passport) {
        this.certificateNumber = certificateNumber;
        this.certificatName = certificatName;
        this.passport = passport;
    }

    public long getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(long certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public String getCertificatName() {
        return certificatName;
    }

    public void setCertificatName(String certificatName) {
        this.certificatName = certificatName;
    }

    public String getDoctor() {
        return passport;
    }

    public void setDoctor(String passport) {
        this.passport = passport;
    }
}
