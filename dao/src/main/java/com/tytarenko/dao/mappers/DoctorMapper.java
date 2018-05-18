package com.tytarenko.dao.mappers;

import com.tytarenko.entities.Doctor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DoctorMapper implements RowMapper<Doctor> {

    @Override
    public Doctor mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Doctor(
                          resultSet.getString("surname"),
                          resultSet.getString("name"),
                          resultSet.getString("patronymic"),
                          resultSet.getString("passport"),
                          resultSet.getString("password"),
                          resultSet.getDate("birthdate"),
                          resultSet.getInt("specialization"),
                          resultSet.getInt("experience"),
                          resultSet.getString("position"),
                          resultSet.getString("degree"));
    }
}
