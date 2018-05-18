package com.tytarenko.entities;

public class Telephone<T> {

    private long telephone;
    private String user;

    public Telephone() {
    }

    public Telephone(long telephone, String user) {
        this.telephone = telephone;
        this.user = user;
    }

    public long getTelephone() {
        return telephone;
    }

    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
