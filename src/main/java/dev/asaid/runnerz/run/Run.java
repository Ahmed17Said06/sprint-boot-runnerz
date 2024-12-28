package dev.asaid.runnerz.run;

import java.time.LocalDateTime;
import java.time.LocalTime;

public record Run(Integer id,
                  String title,
                  LocalDateTime startedOn,
                  LocalDateTime completedOn,
                  Integer miles,
                  Location location)
{

}
