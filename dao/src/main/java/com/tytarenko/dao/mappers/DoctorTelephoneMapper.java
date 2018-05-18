package com.tytarenko.dao.mappers;

import com.tytarenko.entities.Doctor;
import com.tytarenko.entities.Telephone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DoctorTelephoneMapper implements RowMapper<Telephone<Doctor>> {

    @Override
    public Telephone<Doctor> mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Telephone<Doctor>(resultSet.getLong("telephone"),
                resultSet.getString("passport"));
    }

}
