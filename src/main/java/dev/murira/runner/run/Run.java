package dev.murira.runner.run;

import jakarta.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

public record Run(
        Integer id,
        @NotEmpty
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn
) {
    public Run {
        if (completedOn != null && !completedOn.isAfter(startedOn)) {
            throw new IllegalArgumentException("Completed on must be after Started on");
        }
    }
}
