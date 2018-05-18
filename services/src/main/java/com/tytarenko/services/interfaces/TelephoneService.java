package com.tytarenko.services.interfaces;

import com.tytarenko.entities.Telephone;

import java.util.List;

public interface TelephoneService<T> {

    List<Telephone<T>> getTelephone(String passport);
    void addTelephone(Telephone<T> telephone);
    void update(long telephone, long telephoneOld);
    void delete(long telephone);

}