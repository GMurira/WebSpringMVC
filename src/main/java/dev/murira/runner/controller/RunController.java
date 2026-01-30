package dev.murira.runner.controller;

import dev.murira.runner.run.Run;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/runs")
public class RunController {

    private final RunRepository runRepository;

    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    @GetMapping("")
    List<Run> findAll() {
        return runRepository.getAllRuns();
    }

    @GetMapping("1")
    Run findById() {
        return runRepository.findById(1);
    }

    @GetMapping("hello")
    String helloRunner() {
        return "We home you have a nice run";
    }
}
