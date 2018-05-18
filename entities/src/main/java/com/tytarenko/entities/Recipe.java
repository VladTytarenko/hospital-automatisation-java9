package com.tytarenko.entities;

public class Recipe {

    private long id;
    private long reception;
    private String medicament;

    public Recipe() {
    }

    public Recipe(long id, long reception, String medicament) {
        this.id = id;
        this.reception = reception;
        this.medicament = medicament;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMedicament() {
        return medicament;
    }

    public void setMedicament(String medicament) {
        this.medicament = medicament;
    }

    public long getReception() {
        return reception;
    }

    public void setReception(long reception) {
        this.reception = reception;
    }

}
