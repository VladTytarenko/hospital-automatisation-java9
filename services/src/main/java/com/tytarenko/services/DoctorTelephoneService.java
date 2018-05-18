package com.tytarenko.services;

import com.tytarenko.dao.interfaces.TelephoneDao;
import com.tytarenko.entities.Doctor;
import com.tytarenko.entities.Telephone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorTelephoneService implements TelephoneDao<Doctor> {

    @Autowired
    private TelephoneDao<Doctor> doctorTelephoneService;

    @Override
    public List<Telephone<Doctor>> getTelephone(String passport) {
        return doctorTelephoneService.getTelephone(passport);
    }

    @Override
    public void addTelephone(Telephone<Doctor> telephone) {
        doctorTelephoneService.addTelephone(telephone);
    }

    @Override
    public void update(long telephone, long telephoneOld) {
        doctorTelephoneService.update(telephone, telephoneOld);
    }

    @Override
    public void delete(long telephone) {
        doctorTelephoneService.delete(telephone);
    }
}