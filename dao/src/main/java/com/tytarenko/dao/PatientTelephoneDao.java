package com.tytarenko.dao;

import com.tytarenko.dao.interfaces.TelephoneDao;
import com.tytarenko.dao.mappers.PatientTelephoneMapper;
import com.tytarenko.entities.Patient;
import com.tytarenko.entities.Telephone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientTelephoneDao implements TelephoneDao<Patient> {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Telephone<Patient>> getTelephone(String passport) {
        return jdbcTemplate.query("SELECT * FROM telephone_patient WHERE passport = :passport",
                                       new MapSqlParameterSource().addValue("passport", passport),
                                       new PatientTelephoneMapper());
    }

    @Override
    public void addTelephone(Telephone<Patient> telephone) {
        jdbcTemplate.update("INSERT INTO telephone_patient (telephone, passport) VALUES (:telephone," +
                ":passport)",
                new MapSqlParameterSource().addValue("telephone", telephone.getTelephone())
        .addValue("passport", telephone.getUser()));

    }

    @Override
    public void update(long telephone, long telephoneOld) {
        jdbcTemplate.update("UPDATE telephone_patient SET telephone = :telephone" +
                " WHERE telephone = :telephoneOld",
                new MapSqlParameterSource().addValue("telephone", telephone)
        .addValue("telephoneOld", telephoneOld));

    }

    @Override
    public void delete(long telephone) {
        jdbcTemplate.update("DELETE FROM telephone_patient WHERE telephone = :telephone",
                new MapSqlParameterSource().addValue("telephone", telephone));
    }
}
