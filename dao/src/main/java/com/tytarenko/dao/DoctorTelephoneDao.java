package com.tytarenko.dao;

import com.tytarenko.dao.interfaces.TelephoneDao;
import com.tytarenko.dao.mappers.DoctorTelephoneMapper;
import com.tytarenko.entities.Doctor;
import com.tytarenko.entities.Telephone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DoctorTelephoneDao implements TelephoneDao<Doctor> {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Telephone<Doctor>> getTelephone(String passport) {
        return jdbcTemplate.query("SELECT * FROM telephone_doctor WHERE series_number_passport_of_doctor =: passport",
                new MapSqlParameterSource().addValue("passport", passport),
                new DoctorTelephoneMapper());
    }

    @Override
    public void addTelephone(Telephone<Doctor> telephone) {
        jdbcTemplate.update("INSERT INTO telephone_doctor (telephone, series_number_passport_of_doctor) VALUE (:telephone, :passport)",
                new MapSqlParameterSource().addValue("telephone", telephone.getTelephone())
                        .addValue("passport", telephone.getUser()));
    }

    @Override
    public void update(long telephone, long telephoneOld) {
        jdbcTemplate.update("UPDATE telephone_doctor SET telephone = :telephone," +
                " WHERE telephone = :telephoneOld",
                new MapSqlParameterSource().addValue("telephone", telephone)
       .addValue("telephoneOld", telephoneOld));
    }

    @Override
    public void delete(long telephone) {
        jdbcTemplate.update("DELETE FROM telephone_doctor WHERE telephone = :telephone",
                new MapSqlParameterSource().addValue("telephone", telephone));
    }
}
