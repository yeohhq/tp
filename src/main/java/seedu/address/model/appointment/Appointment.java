package seedu.address.model.appointment;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import seedu.address.model.patient.Patient;
import seedu.address.model.tag.Tag;


/**
 * Represents an Appoint in the Archangel
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Appointment {
    // Identity fields
    private final LocalDateTime start;
    private final LocalDateTime end;
    private final Patient patient;
    private final Set<Tag> tags = new HashSet<>();
    private final Boolean isCompleted;
    private final Boolean isMissed;
    private final String description;

    /**
     * Every field must be present and not null.
     */
    public Appointment(LocalDateTime start, LocalDateTime end, Patient patient, Set<Tag> tags,
                       Boolean isCompleted, Boolean isMissed, String description) {
        this.start = start;
        this.end = end;
        this.patient = patient;
        this.isCompleted = isCompleted;
        this.isMissed = isMissed;
        this.description = description;
        this.tags.addAll(tags);
    }

    public Patient getPatient() {
        return this.patient;
    }

    public Boolean isMissed() {
        return this.isMissed;
    }

    public Boolean isCompleted() {
        return this.isCompleted;
    }
}
