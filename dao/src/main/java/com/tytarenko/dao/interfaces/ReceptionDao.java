package com.tytarenko.dao.interfaces;

import com.tytarenko.entities.Reception;

import java.util.List;

public interface ReceptionDao {

    Reception getReceptionById(long id);
    List<Reception> getReceptionOfPatient(String passport);
    List<Reception> getReceptionOfDoctor(String passport);
    void addReception(Reception reception);
}
