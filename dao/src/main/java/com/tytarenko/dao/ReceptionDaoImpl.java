package com.tytarenko.dao;

import com.tytarenko.dao.interfaces.ReceptionDao;
import com.tytarenko.dao.mappers.PatientMapper;
import com.tytarenko.dao.mappers.ReceptionMapper;
import com.tytarenko.dao.mappers.ReferalMapper;
import com.tytarenko.entities.Reception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReceptionDaoImpl implements ReceptionDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public Reception getReceptionById(long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM reception WHERE id = :id",
                new MapSqlParameterSource().addValue("id", id),
                new ReceptionMapper());
    }

    @Override
    public List<Reception> getReceptionOfPatient(String passport) {
        return jdbcTemplate.query("SELECT * FROM reception WHERE patient_passport = :passport",
                new MapSqlParameterSource("passport", passport),
                new ReceptionMapper());
    }

    @Override
    public List<Reception> getReceptionOfDoctor(String passport) {
        return jdbcTemplate.query("SELECT * FROM reception WHERE doctor_passport = :passport",
                new MapSqlParameterSource("passport", passport),
                new ReceptionMapper());
    }

    @Override
    public void addReception(Reception reception) {
        jdbcTemplate.query("INSERT INTO reception (doctor_passport, patient_passport, date, price) " +
                "VALUES (:doc_pass, :patient_pass, :date, :price",
                new MapSqlParameterSource()
                        .addValue("doc_pass", reception.getDoctorPassport())
                        .addValue("patient_pass", reception.getPatientPassport())
                        .addValue("date", reception.getDate())
                        .addValue("price", reception.getDate()),
                new ReferalMapper());
    }
}
