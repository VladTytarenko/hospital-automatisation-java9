package com.tytarenko.dao.mappers;

import com.tytarenko.entities.Patient;
import com.tytarenko.entities.Telephone;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientTelephoneMapper implements RowMapper<Telephone<Patient>> {


    @Override
    public Telephone<Patient> mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Telephone<Patient>(resultSet.getLong("telephone"),
                                      resultSet.getString("passport"));
    }
}
