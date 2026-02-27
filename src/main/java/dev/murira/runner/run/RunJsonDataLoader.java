package dev.murira.runner.run;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.murira.runner.controller.RunRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class RunJsonDataLoader implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(RunJsonDataLoader.class);
    private final RunRepository runRepository;
    private final ObjectMapper objectMapper;

    public RunJsonDataLoader(RunRepository runRepository, ObjectMapper objectMapper) {
        this.runRepository = runRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        long currentCount = runRepository.count();

        if (currentCount == 0) {
            try (InputStream inputStream = getClass().getResourceAsStream("/data/runs.json")) {
                if (inputStream == null) {
                    logger.error("JSON file not found at /data/runs.json");
                    return;
                }

                // Note: Ensure you have a 'Runs' record/class to wrap the List
                Runs allRuns = objectMapper.readValue(inputStream, Runs.class);
                logger.info("Reading {} runs from JSON and saving to database.", allRuns.runs().size());
                runRepository.saveAll(allRuns.runs());

            } catch (IOException e) {
                logger.error("Failed to read JSON data", e);
                throw new RuntimeException("Failed to read JSON data", e);
            }
        } else {
            logger.info("Database already contains {} records. Skipping JSON data load.", currentCount);
        }
    }
}