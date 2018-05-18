package com.tytarenko.services;

import com.tytarenko.dao.interfaces.DoctorDao;
import com.tytarenko.entities.Doctor;
import com.tytarenko.services.interfaces.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorDao doctorDao;

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorDao.getAllDoctors();
    }

    @Override
    public List<Doctor> getBySpecialization(long id) {
        return doctorDao.getBySpecialization(id);
    }

    @Override
    public List<Doctor> getFamilyDoctors() {
        return doctorDao.getFamilyDoctors();
    }

    @Override
    public Doctor getByPassport(String passport) {
        return doctorDao.getByPassport(passport);
    }

    @Override
    public void addDoctor(Doctor doctor) {
        doctorDao.addDoctor(doctor);
    }

    @Override
    public void updateDoctor(Doctor doctor, String passport) {
        doctorDao.updateDoctor(doctor, passport);
    }

    @Override
    public void deleteDoctorByPassport(String passport) {
        doctorDao.deleteDoctorByPassport(passport);
    }
}
