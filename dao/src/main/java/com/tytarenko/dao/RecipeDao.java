package com.tytarenko.dao;

import com.tytarenko.dao.interfaces.DaoInterface;
import com.tytarenko.dao.mappers.RecipeMapper;
import com.tytarenko.entities.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RecipeDao implements DaoInterface<Recipe> {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;


    @Override
    public List<Recipe> get(String passport) {
        return jdbcTemplate.query("SELECT R.id, R.medicament, R.reception_id\n" +
                "FROM recipe AS R\n" +
                "     INNER JOIN\n" +
                "     (SELECT id, patient_passport FROM reception WHERE patient_passport = :passport) AS REC\n" +
                "     ON\n" +
                "     R.reception_id = REC.id",
                new MapSqlParameterSource("passport", passport),
                new RecipeMapper());
    }

    @Override
    public List<Recipe> getByReception(long id) {
        return jdbcTemplate.query("SELECT * FROM recipe WHERE reception_id = :id",
                new MapSqlParameterSource().addValue("id", id),
                new RecipeMapper());
    }

    @Override
    public void add(Recipe object) {
        jdbcTemplate.update("INSERT INTO recipe (medicament, reception_id) VALUES (:medicament, :reception_id)",
                new MapSqlParameterSource().addValue("medicament", object.getMedicament())
        .addValue("reception_id", object.getReception()));
    }
}
