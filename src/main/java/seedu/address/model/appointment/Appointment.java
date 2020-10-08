package seedu.address.model.appointment;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.model.patient.Patient;
import seedu.address.model.tag.Tag;


/**
 * Represents an Appoint in the Archangel
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Appointment {

    // Identity fields
    private final AppointmentTime appointmentTime;
    private final Patient patient;
    private final Set<Tag> tags = new HashSet<>();
    private final Boolean isCompleted;
    private final Boolean isMissed;
    private final Description description;

    /**
     * Every field must be present and not null.
     */
    public Appointment(AppointmentTime appointmentTime, Patient patient, Set<Tag> tags,
                       Boolean isCompleted, Boolean isMissed, Description description) {
        this.appointmentTime = appointmentTime;
        this.patient = patient;
        this.isCompleted = isCompleted;
        this.isMissed = isMissed;
        this.description = description;
        this.tags.addAll(tags);
    }

    public AppointmentTime getAppointmentTime() {
        return this.appointmentTime;
    }

    public LocalDateTime getStartTime() {
        return this.appointmentTime.getStart();
    }

    public LocalDateTime getEndTime() {
        return this.appointmentTime.getEnd();
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

    public Description getDescription() {
        return this.description;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    /**
     * Returns true if both appointments have the same appointment time, patient, description.
     * This defines a weaker notion of equality between two appointments.
     */
    public boolean isSameAppointment(Appointment otherAppointment) {
        if (otherAppointment == this) {
            return true;
        }

        return otherAppointment != null
                && otherAppointment.getAppointmentTime().equals(getAppointmentTime())
                && otherAppointment.getPatient().equals(getPatient())
                && otherAppointment.getDescription().equals(getDescription());

    }

    /**
     * Returns true if both appointments have the same identity and data fields.
     * This defines a stronger notion of equality between two appointments.
     */
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Appointment)) {
            return false;
        }

        Appointment otherAppointment = (Appointment) other;
        return otherAppointment != null
                && otherAppointment.getAppointmentTime().equals(getAppointmentTime())
                && otherAppointment.getPatient().equals(getPatient())
                && otherAppointment.isMissed().equals(isMissed())
                && otherAppointment.isCompleted().equals(isCompleted())
                && otherAppointment.getDescription().equals(getDescription())
                && otherAppointment.getTags().equals(getTags());
    }

    @Override
    public int hashCode() {
        // custom fields hashing
        return Objects.hash(appointmentTime, patient, isMissed, isCompleted, description, tags);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getDescription())
                .append(" Start: ")
                .append(getStartTime())
                .append(" End: ")
                .append(getEndTime())
                .append(" Patient: ")
                .append(getPatient())
                .append(" isMissed: ")
                .append(isMissed())
                .append(" isCompleted: ")
                .append(isCompleted())
                .append(" Tags: ");
        getTags().forEach(builder::append);
        return builder.toString();
    }

}
