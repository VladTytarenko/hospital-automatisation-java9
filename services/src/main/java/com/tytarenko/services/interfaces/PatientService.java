package com.tytarenko.services.interfaces;

import com.tytarenko.entities.Patient;

import java.util.List;


public interface PatientService {

    Patient getPatientByPassport(String passport);
    List<Patient> getAllPatient();
    List<Patient> getPatientsOfDoctor(String doctor);
    void insetNewPatient(Patient patient);
    void updatePatient(Patient patient, String passport);
    void deletePatientByPassport(String passport);
}
