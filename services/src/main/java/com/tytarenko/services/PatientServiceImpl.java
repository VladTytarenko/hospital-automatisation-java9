package com.tytarenko.services;

import com.tytarenko.dao.interfaces.PatientDao;
import com.tytarenko.entities.Patient;
import com.tytarenko.services.interfaces.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientDao patientDao;

    @Override
    public Patient getPatientByPassport(String passport) {
        return patientDao.getPatientByPassport(passport);
    }

    @Override
    public List<Patient> getAllPatient() {
        return patientDao.getAllPatient();
    }

    @Override
    public List<Patient> getPatientsOfDoctor(String doctor) {
        return patientDao.getPatientsOfDoctor(doctor);
    }

    @Override
    public void insetNewPatient(Patient patient) {
        patientDao.insetNewPatient(patient);
    }

    @Override
    public void updatePatient(Patient patient, String passport) {
        patientDao.updatePatient(patient, passport);
    }

    @Override
    public void deletePatientByPassport(String passport) {
        patientDao.deletePatientByPassport(passport);
    }
}
