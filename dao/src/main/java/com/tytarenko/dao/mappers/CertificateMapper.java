package com.tytarenko.dao.mappers;

import com.tytarenko.entities.Certificate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CertificateMapper implements RowMapper<Certificate> {

    @Override
    public Certificate mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Certificate(resultSet.getLong("id"),
                resultSet.getString("name"),
                resultSet.getString("passport"));
    }

}
