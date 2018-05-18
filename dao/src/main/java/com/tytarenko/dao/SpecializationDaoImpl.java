package com.tytarenko.dao;

import com.tytarenko.dao.interfaces.SpecializationDao;
import com.tytarenko.dao.mappers.SpecializationMapper;
import com.tytarenko.entities.Specialization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SpecializationDaoImpl implements SpecializationDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Specialization> getAllSpecialization() {
        return jdbcTemplate.query("SELECT * FROM specialization",
                new SpecializationMapper());
    }
}
