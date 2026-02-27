package dev.murira.runner.run;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import java.time.LocalDateTime;

// 1. Remove @Entity (JDBC doesn't use it)
public record Run(
        @Id // 2. Ensure this is org.springframework.data.annotation.Id
        Integer id,
        @NotEmpty
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        @Version // 3. This handles optimistic locking in JDBC too
        Integer version
) {
    public Run {
        if (completedOn != null && startedOn != null && !completedOn.isAfter(startedOn)) {
            throw new IllegalArgumentException("Completed on must be after started on");
        }
    }
}