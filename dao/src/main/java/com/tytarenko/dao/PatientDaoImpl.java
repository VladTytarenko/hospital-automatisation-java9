package com.tytarenko.dao;

import com.tytarenko.dao.interfaces.PatientDao;
import com.tytarenko.dao.mappers.PatientMapper;
import com.tytarenko.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public class PatientDaoImpl implements PatientDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public Patient getPatientByPassport(String passport) {
        return jdbcTemplate.queryForObject("SELECT" +
                        " PP.passport," +
                        " PP.surname," +
                        " PP.name," +
                        " PP.patronymic," +
                        " P.address," +
                        " P.email," +
                        " P.birthdate," +
                        " P.registration_date," +
                        " P.invalidity," +
                        " P.insurance_company," +
                        " P.insurance_type," +
                        " P.insurance_policy_number" +
                        " FROM (SELECT * FROM patient_passport " +
                "WHERE passport = :passport) AS PP JOIN patient AS P " +
                "ON PP.passport = P.passport",
                new MapSqlParameterSource().addValue("passport", passport),
                new PatientMapper());
    }

    @Override
    public List<Patient> getAllPatient() {
        return jdbcTemplate.query("SELECT" +
                " PP.passport," +
                " PP.surname," +
                " PP.name," +
                " PP.patronymic," +
                " P.address," +
                " P.email," +
                " P.birthdate," +
                " P.registration_date," +
                " P.invalidity," +
                " P.insurance_company," +
                " P.insurance_type," +
                " P.insurance_policy_number" +
                " FROM (SELECT * FROM patient_passport) " +
                "AS PP JOIN patient AS P " +
                "ON PP.passport = P.passport", new PatientMapper());
    }

    @Override
    public List<Patient> getPatientsOfDoctor(String passport) {
        return jdbcTemplate.query("SELECT" +
                        " PM.passport," +
                        " PP.surname," +
                        " PP.name," +
                        " PP.patronymic,\n" +
                        "        PM.address,\n" +
                        "        PM.email,\n" +
                        "        PM.birthdate,\n" +
                        "        PM.registration_date,\n" +
                        "        PM.invalidity,\n" +
                        "        PM.insurance_company,\n" +
                        "        PM.insurance_type,\n" +
                        "        PM.insurance_policy_number\n" +
                        "FROM (((SELECT patient_passport\n" +
                        "     FROM reception\n" +
                        "     WHERE doctor_passport = :passport) AS P\n" +
                        "     JOIN\n" +
                        "\t patient_passport AS PP\n" +
                        "     ON\n" +
                        "     P.patient_passport = PP.passport) \n" +
                        "     JOIN \n" +
                        "     patient AS PM\n" +
                        "     ON \n" +
                        "     PP.passport = PM.passport) ",
                new MapSqlParameterSource("passport", passport),
                new PatientMapper());
    }

    @Override
    public void insetNewPatient(Patient patient) {
        jdbcTemplate.update("INSERT INTO patient_passport(passport, surname, name, patronymic)" +
                "VALUES (:passport, :surname, :name, :patronymic)",
                new MapSqlParameterSource().addValue("passport", patient.getPassport())
        .addValue("surname", patient.getSurname())
        .addValue("name", patient.getName())
        .addValue("patronymic", patient.getPatronymic()));

        jdbcTemplate.update("INSERT INTO patient (passport, " +
                "address, email, birthdate, registration_date, " +
                "invalidity, insurance_company, insurance_policy_number, insurance_type) VALUES (:passport, " +
                ":address, :email, :birthdate, :registration_date, " +
                ":invalidity, :insurance_company, :insurance_policy_number, :insurance_type)",
                new MapSqlParameterSource()
                        .addValue("passport", patient.getPassport())
                        .addValue("address", patient.getAddress())
                        .addValue("email", patient.getEmail())
                        .addValue("birthdate", patient.getBirthdate())
                        .addValue("registration_date", patient.getRegistrationDate())
                        .addValue("invalidity", patient.getInvalidity())
                        .addValue("insurance_company", patient.getInsuranceCompany())
                        .addValue("insurance_policy_number", patient.getInsuranceNumber())
                        .addValue("insurance_type", patient.getInsuranceType())
        );
    }

    @Override
    public void updatePatient(Patient patient, String passport) {
        jdbcTemplate.update("UPDATE patient_passport SET passport = :passport," +
                "surname = :surname, name = :name, patronymic = :patronymic WHERE passport = :p",
                new MapSqlParameterSource()
                        .addValue("passport", patient.getPassport())
                        .addValue("surname", patient.getSurname())
                        .addValue("name", patient.getName())
                        .addValue("patronymic", patient.getPatronymic())
                        .addValue("p", passport)
        );

        jdbcTemplate.update("UPDATE patient SET " +
                "address = :address, email = :email, birthdate = :birthdate, " +
                "registration_date = :rd, invalidity = :inv, insurance_company = :ic, " +
                "insurance_type = :t, insurance_policy_number = :ipn WHERE passport = :p",
                new MapSqlParameterSource()
                        .addValue("address", patient.getAddress())
                        .addValue("email", patient.getEmail())
                        .addValue("birthdate", patient.getBirthdate())
                        .addValue("rd", patient.getRegistrationDate())
                        .addValue("inv", patient.getInvalidity())
                        .addValue("ic", patient.getInsuranceCompany())
                        .addValue("t", patient.getInsuranceType())
                        .addValue("ipn", patient.getInsuranceNumber())
                        .addValue("p", passport)//patient.getPassport())
        );
    }

    @Override
    public void deletePatientByPassport(String passport) {
        jdbcTemplate.update("DELETE FROM patient_passport WHERE passport = :passport",
                new MapSqlParameterSource().addValue("passport", passport));

    }
}
