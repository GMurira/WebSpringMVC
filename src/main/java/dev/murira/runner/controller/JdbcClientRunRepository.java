package dev.murira.runner.controller;

import dev.murira.runner.run.Run;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcClientRunRepository {
    private static final Logger logger = LoggerFactory.getLogger(JdbcClientRunRepository.class);
    private final JdbcClient jdbcClient;

    public JdbcClientRunRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Run> findAll() {
        return jdbcClient.sql("SELECT id, title, started_on, completed_on, version FROM run")
                .query(Run.class)
                .list();
    }

    public void create(Run run) {
        // Ensure version is not null
        Integer version = run.version() != null ? run.version() : 0;

        var updated = jdbcClient.sql(
                        "INSERT INTO run(id, title, started_on, completed_on, version) VALUES (?,?,?,?,?)")
                .params(List.of(
                        run.id(),
                        run.title(),
                        Timestamp.valueOf(run.startedOn()),
                        Timestamp.valueOf(run.completedOn()),
                        version
                ))
                .update();

        Assert.state(updated == 1, "Failed to create run: " + run.title());
    }

    public Optional<Run> findById(Integer id) {
        return jdbcClient.sql("SELECT id, title, started_on, completed_on, version FROM run WHERE id = :id")
                .param("id", id)
                .query(Run.class)
                .optional();
    }

    public void delete(Integer id) {
        var updated = jdbcClient.sql("DELETE FROM run WHERE id = :id")
                .param("id", id)
                .update();

        if (updated == 0) {
            throw new RuntimeException("Run not found with id " + id);
        }
    }

    public void saveAll(List<Run> runs) {
        runs.forEach(this::create);
    }

    public Integer count() {
        return jdbcClient.sql("SELECT * FROM run")
                .query()
                .listOfRows()
                .size();
    }

    public List<Run> findAllByTitle(String title) {

        return jdbcClient.sql("SELECT * FROM run where title ILIKE: title")
                .params("title", title)
                .query(Run.class)
                .list();
    }
}