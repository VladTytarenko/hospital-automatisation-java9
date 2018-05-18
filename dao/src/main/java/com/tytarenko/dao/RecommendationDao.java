package com.tytarenko.dao;

import com.tytarenko.dao.interfaces.DaoInterface;
import com.tytarenko.dao.mappers.RecommendationMapper;
import com.tytarenko.entities.Recommendation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RecommendationDao implements DaoInterface<Recommendation> {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Recommendation> get(String passport) {
        return jdbcTemplate.query("SELECT R.id, R.recommendation, R.reception_id\n" +
                        "FROM recommendation AS R\n" +
                        "     INNER JOIN\n" +
                        "     (SELECT id, patient_passport FROM reception WHERE patient_passport = :passport) AS REC\n" +
                        "     ON\n" +
                        "     R.reception_id = REC.id",
                new MapSqlParameterSource("passport", passport),
                new RecommendationMapper());
    }

    @Override
    public List<Recommendation> getByReception(long id) {
        return jdbcTemplate.query("SELECT * FROM recommendation WHERE reception_id = :id",
                new MapSqlParameterSource().addValue("id", id),
                new RecommendationMapper());
    }

    @Override
    public void add(Recommendation object) {
        jdbcTemplate.update("INSERT INTO recommendation (recommendation, reception_id) VALUES (:recommendation, :reception_id)",
                new MapSqlParameterSource().addValue("recommendation", object.getRecommendation())
                        .addValue("reception_id", object.getReception()));
    }
}
