package com.tytarenko.dao.interfaces;

import com.tytarenko.entities.Referal;

import java.util.List;

public interface ReferalDao {

    void addReferal(Referal referal);
    List<Referal> getReferalOfDoctor(String passport);
    List<Referal> getReferalOfPatient(String patient);

}
