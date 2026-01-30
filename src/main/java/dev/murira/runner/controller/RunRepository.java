package dev.murira.runner.controller;

import dev.murira.runner.run.Run;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RunRepository {
    private List<Run> runs = new ArrayList<>();

    public List<Run> getAllRuns() {
        return runs;
    }

    Run findById(Integer id){
        return runs.stream()
                .filter(run -> run.id() ==id)
                .findFirst()
                .get();
    }

    @PostConstruct
    private void init() {
        runs.add(new Run(
                1,
                "Tuesday run",
                LocalDateTime.now(),
                LocalDateTime.now().plus(1, ChronoUnit.HOURS)
        ));

        runs.add(new Run(
                2,
                "Wednesday run",
                LocalDateTime.now(),
                LocalDateTime.now().plus(2, ChronoUnit.HOURS)
        ));
    }
}
