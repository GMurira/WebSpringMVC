package dev.murira.runner.controller;

import dev.murira.runner.run.Run;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunRepository {
    private static final Logger logger = LoggerFactory.getLogger(RunRepository.class);
    private final JdbcClient jdbcClient;


    public RunRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Run> findAll() {
        return jdbcClient.sql("SELECT * FROM run")
                .query(Run.class)
                .list();
    }

    public void create(Run run) {
        var updated = jdbcClient.sql("INSERT INTO run(id, title, started_on,completed_on)values (?,?,?,?)")
                .params(List.of(run.id(), run.title(), run.startedOn(), run.completedOn().toString()))
                .update();

        Assert.state(updated == 1, "Failed to create run" + run.title());
    }

    public Optional<Run> findById(Integer id){
        return jdbcClient.sql("SELECT id, title, started_on,completed_on FROM run WHERE id = :id")
                .param("id",id)
                .query(Run.class)
                .optional();
    }

    public
}
