package seedu.address.model.appointment;

import seedu.address.model.patient.*;
import seedu.address.model.tag.Tag;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Appointment {
    // Identity fields
    private final LocalDateTime start;
    private final LocalDateTime end;
    private final Patient patient;
    private final Set<Tag> tags = new HashSet<>();
    private final Boolean isComplete;
    private final Boolean isMissed;
    private final String description;

    public Appointment(LocalDateTime start, LocalDateTime end, Patient patient, Set<Tag> tags,
                       Boolean isComplete, Boolean isMissed, String description) {
        this.start = start;
        this.end = end;
        this.patient = patient;
        this.isComplete = isComplete;
        this.isMissed = isMissed;
        this.description = description;
        this.tags.addAll(tags);
    }
}
