package com.tytarenko.dao.mappers;

import com.tytarenko.entities.Reception;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReceptionMapper implements RowMapper<Reception> {

    @Override
    public Reception mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Reception(resultSet.getLong("id"),
                             resultSet.getString("doctor_passport"),
                             resultSet.getString("patient_passport"),
                             resultSet.getDate("date"),
                             resultSet.getLong("price"));
    }

}

