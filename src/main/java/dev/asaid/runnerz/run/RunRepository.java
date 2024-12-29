package dev.asaid.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Repository
public class RunRepository {
    private List<Run> runs = new ArrayList<>();

    List<Run> findAll() {
        return runs;
    }

    Optional<Run> findById(Integer id) {
        return runs.stream()
                .filter(run -> run.id().equals(id))
                .findFirst();
    }


    void create(Run run) {
        runs.add(run);
    }


    void update(Run run) {
        Optional<Run> existingRun = findById(run.id());
        if(existingRun.isEmpty()) {
            throw new IllegalArgumentException("Run not found");
        }
        runs.remove(existingRun.get());
        runs.add(run);
    }

    void delete(Integer id) {
        Optional<Run> existingRun = findById(id);
        if(existingRun.isEmpty()) {
            throw new IllegalArgumentException("Run not found");
        }
        runs.remove(existingRun.get());
    }


    @PostConstruct
    private void init() {
        runs.add(new Run(1, "Monday Morning Run", LocalDateTime.now(), LocalDateTime.now().plus(30, ChronoUnit.HOURS), 5, Location.OUTDOOR));
        runs.add(new Run(2, "Wednesday Evening Run", LocalDateTime.now(), LocalDateTime.now().plus(60, ChronoUnit.HOURS), 5, Location.OUTDOOR));
    }
}
