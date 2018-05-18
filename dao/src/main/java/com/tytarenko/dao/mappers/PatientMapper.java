package com.tytarenko.dao.mappers;

import com.tytarenko.entities.Patient;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class PatientMapper implements RowMapper<Patient> {

    @Override
    public Patient mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Patient(
        resultSet.getString("passport"),
        resultSet.getString("surname"),
        resultSet.getString("name"),
        resultSet.getString("patronymic"),
        resultSet.getString("address"),
        resultSet.getString("email"),
        resultSet.getDate("birthdate"),
        resultSet.getDate("registration_date"),
        resultSet.getString("invalidity"),
        resultSet.getString("insurance_company"),
        resultSet.getString("insurance_type"),
        resultSet.getString("insurance_policy_number"));
    }
}
