package com.m2p.sampleapp.repository;

import com.m2p.sampleapp.util.TrackExecutionTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository("CalcRepositoryImpl")
public class CalcRepositoryImpl implements CalcRepository {
    @Autowired
    @Qualifier("h2-db")
    private NamedParameterJdbcTemplate jdbcTemplate;

    @TrackExecutionTime
    @Override
    public Double calcResult(Double inp1, char operator, Double inp2) {
        String sql = "SELECT ".concat(":inp1").concat(" ").concat(String.valueOf(operator)).concat(" ")
                .concat(":inp2");
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("inp1", inp1)
                .addValue("inp2", inp2);
        return jdbcTemplate.queryForObject(sql, namedParameters, Double.class);
    }
}
