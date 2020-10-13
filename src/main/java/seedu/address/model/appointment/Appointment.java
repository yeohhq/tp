package seedu.address.model.appointment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.patient.Patient;
import seedu.address.model.tag.Tag;

/**
 * Represents an Appoint in the Archangel
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Appointment {

    // Identity fields
    private final AppointmentTime appointmentTime;
    private Patient patient;
    private final String patientString;
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
        this.patientString = null;
        this.isCompleted = isCompleted;
        this.isMissed = isMissed;
        this.description = description;
        this.tags.addAll(tags);
    }

    /**
     * Every field must be present and not null.
     */
    public Appointment(AppointmentTime appointmentTime, String patientString, Set<Tag> tags,
                       Boolean isCompleted, Boolean isMissed, Description description) {
        this.appointmentTime = appointmentTime;
        this.patient = null;
        this.patientString = patientString;
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

    public String getPatientString() {
        return this.patientString;
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
     * Parses patientString to change patient field in appointment
     * @param addressBook
     */
    public void parsePatient(ReadOnlyAddressBook addressBook) {
        ArrayList<Patient> arr = new ArrayList<>(addressBook.getPatientList());
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getName().toString().equalsIgnoreCase(patientString)) {
                patient = arr.get(i);
            }
        }
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
        System.out.println(otherAppointment.patientString);
        return otherAppointment != null
                && otherAppointment.getAppointmentTime().equals(getAppointmentTime())
                && otherAppointment.getPatientString().equals(getPatientString())
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
