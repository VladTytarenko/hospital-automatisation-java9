package com.tytarenko.entities;

public class Recommendation {

    private long id;
    private long reception;
    private String recommendation;

    public Recommendation() {
    }

    public Recommendation(long reception, String recommendation) {
        this.reception = reception;
        this.recommendation = recommendation;
    }

    public Recommendation(long id, long reception, String recommendation) {
        this.id = id;
        this.reception = reception;
        this.recommendation = recommendation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getReception() {
        return reception;
    }

    public void setReception(long reception) {
        this.reception = reception;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }
}
