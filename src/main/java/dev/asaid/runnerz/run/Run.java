package dev.asaid.runnerz.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;
import java.time.LocalTime;

public record Run(Integer id,
                  @NotEmpty
                  String title,
                  LocalDateTime startedOn,
                  LocalDateTime completedOn,
                  @Positive
                  Integer miles,
                  Location location)
{

    public Run {
        if (id == null || id < 1) {
            throw new IllegalArgumentException("Invalid run id");
        }
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Invalid run title");
        }
        if (startedOn == null || startedOn.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("Invalid run start time");
        }
        if (completedOn == null || completedOn.isBefore(startedOn)) {
            throw new IllegalArgumentException("Invalid run end time");
        }
        if (miles == null || miles < 1) {
            throw new IllegalArgumentException("Invalid run miles");
        }
        if (location == null) {
            throw new IllegalArgumentException("Invalid run location");
        }
    }

}
