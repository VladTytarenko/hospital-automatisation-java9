package com.tytarenko.dao.mappers;

import com.tytarenko.entities.Recommendation;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RecommendationMapper implements RowMapper<Recommendation> {

    @Override
    public Recommendation mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Recommendation(resultSet.getLong("id"),
                                  resultSet.getLong("reception_id"),
                                  resultSet.getString("recommendation"));
    }

}
