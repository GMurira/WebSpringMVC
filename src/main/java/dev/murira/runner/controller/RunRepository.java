package dev.murira.runner.controller;

import dev.murira.runner.run.Run;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface RunRepository extends ListCrudRepository<Run, Integer> {
    List<Run> findAllByTitle(String title);
}
