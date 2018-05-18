package com.tytarenko.dao.interfaces;

import com.tytarenko.entities.Telephone;

import java.util.List;

public interface TelephoneDao<T> {

    List<Telephone<T>> getTelephone(String passport);
    void addTelephone(Telephone<T> telephone);
    void update(long telephone, long telephoneOld);
    void delete(long telephone);

}