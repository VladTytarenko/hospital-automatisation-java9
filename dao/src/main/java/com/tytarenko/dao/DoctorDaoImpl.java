package com.tytarenko.dao;

import com.tytarenko.dao.interfaces.DoctorDao;
import com.tytarenko.dao.mappers.DoctorMapper;
import com.tytarenko.entities.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DoctorDaoImpl implements DoctorDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Doctor> getAllDoctors() {
        return jdbcTemplate.query("SELECT DP.passport, DP.surname, DP.name, DP.patronymic, DP.password, D.birthdate, D.specialization," +
                " D.experience, D.position, D.degree" +
                        " FROM" +
                        " (SELECT * FROM doctor_passport) AS DP" +
                        " JOIN" +
                        " doctor AS D" +
                        " ON" +
                        " D.passport = DP.passport",
                new DoctorMapper());
    }

    @Override
    public List<Doctor> getBySpecialization(long id) {
        return jdbcTemplate.query("SELECT DP.passport, DP.surname, DP.name, DP.patronymic, DP.password, D.birthdate, D.specialization,"  +
                                " D.experience, D.position, D.degree" +
                " FROM" +
                " (SELECT * FROM doctor_passport) AS DP" +
                " JOIN" +
                " (SELECT * FROM doctor WHERE specialization = :s) AS D" +
                " ON" +
                " D.passport = DP.passport",
                new MapSqlParameterSource().addValue("s", id),
                new DoctorMapper());
    }

    @Override
    public List<Doctor> getFamilyDoctors() {
        return jdbcTemplate.query("SELECT DP.passport, DP.surname, DP.name, DP.patronymic, DP.password, D.birthdate, D.specialization,"  +
                        " D.experience, D.position, D.degree" +
                        " FROM" +
                        " (SELECT * FROM doctor_passport) AS DP" +
                        " JOIN" +
                        " (SELECT * FROM doctor WHERE specialization = 1) AS D" +
                        " ON" +
                        " D.passport = DP.passport",
                new DoctorMapper());
    }

    @Override
    public Doctor getByPassport(String passport) {
        return jdbcTemplate.queryForObject("SELECT DP.passport, DP.surname, DP.name, DP.patronymic, DP.password, D.birthdate, D.specialization," +
                        " D.experience, D.position, D.degree" +
                        " FROM" +
                        " (SELECT * FROM doctor_passport WHERE passport = :passport) AS DP" +
                        " JOIN" +
                        " doctor AS D" +
                        " ON" +
                        " D.passport = DP.passport",
                new MapSqlParameterSource().addValue("passport", passport),
                new DoctorMapper());
    }

    @Override
    public void addDoctor(Doctor doctor) {
        jdbcTemplate.update("INSERT INTO doctor_passport(passport, surname, name, patronymic, password) VALUES (:passport," +
                        " :surname, :name, :patronymic, :password)",
                new MapSqlParameterSource()
        .addValue("passport", doctor.getPassport())
        .addValue("surname", doctor.getSurname())
        .addValue("name", doctor.getName())
        .addValue("patronymic", doctor.getPatronymic())
        .addValue("password", doctor.getPassword()));

        jdbcTemplate.update("INSERT INTO doctor (passport, birthdate, experience, specialization, " +
                "position, degree) VALUES (:passport, :birthdate, :experience, :specialization, " +
                ":position, :degree)", new MapSqlParameterSource()
        .addValue("passport", doctor.getPassport())
                .addValue("birthdate", doctor.getBirthdate())
                .addValue("experience", doctor.getExperience())
                .addValue("specialization", doctor.getSpecialization())
                .addValue("position", doctor.getPosition())
                .addValue("degree", doctor.getDegree()));
    }

    @Override
    public void updateDoctor(Doctor doctor, String passport) {
        jdbcTemplate.update("UPDATE doctor_passport SET passport = :passport, surname = :surname, name = :name, patronymic = :patronymic, password = :password WHERE" +
                        " passport = :pass",
                new MapSqlParameterSource()
                        .addValue("passport", doctor.getPassport())
                        .addValue("surname", doctor.getSurname())
                        .addValue("name", doctor.getName())
                        .addValue("patronymic", doctor.getPatronymic())
                        .addValue("password", doctor.getPassword())
        .addValue("pass", passport));

        jdbcTemplate.update("UPDATE doctor SET birthdate = :birthdate," +
                " experience = :experience, specialization = :specialization, " +
                "position = :position, degree = :degree WHERE passport = :pass", new MapSqlParameterSource()
                .addValue("birthdate", doctor.getBirthdate())
                .addValue("experience", doctor.getExperience())
                .addValue("specialization", doctor.getSpecialization())
                .addValue("position", doctor.getPosition())
                .addValue("degree", doctor.getDegree())
                .addValue("pass", passport));
    }

    @Override
    public void deleteDoctorByPassport(String passport) {
        jdbcTemplate.update("DELETE FROM doctor_passport WHERE passport = :passport",
                new MapSqlParameterSource("passport", passport));
    }

}