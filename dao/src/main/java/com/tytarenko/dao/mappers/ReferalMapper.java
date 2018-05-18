package com.tytarenko.dao.mappers;

import com.tytarenko.entities.Referal;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReferalMapper implements RowMapper<Referal> {

    @Override
    public Referal mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Referal(resultSet.getLong("id"),
                resultSet.getString("patient_id"),
                resultSet.getString("doctor_passport_from"),
                resultSet.getInt("specialization"));
    }
}
