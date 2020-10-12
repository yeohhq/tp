package seedu.address.testutil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.time.LocalDateTime;

import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.appointment.Appointment;
import seedu.address.model.appointment.AppointmentTime;
import seedu.address.model.appointment.Description;
import seedu.address.model.patient.*;
import seedu.address.model.tag.Tag;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Appointment objects.
 */
public class AppointmentBuilder {

    public static final AppointmentTime DEFAULT_TIME = new AppointmentTimeBuilder().build();
    public static final Patient DEFAULT_PATIENT = new PatientBuilder().build();
    public static final String DEFAULT_DESCRIPTION = "Appointment";
    public static final boolean DEFAULT_COMPLETE = false;
    public static final boolean DEFAULT_MISSED = false;

    public AppointmentTime appointmentTime;
    public Patient patient;
    public Description description;
    private Set<Tag> tags;


    /**
     * Creates a {@code AppointmentBuilder} with the default details.
     */
    public AppointmentBuilder() {
        appointmentTime = DEFAULT_TIME;
        patient = DEFAULT_PATIENT;
        description = new Description(DEFAULT_DESCRIPTION);
        tags = new HashSet<>();
    }

    /**
     * Initializes the AppointmentBuilder with the data of {@code appointmentToCopy}.
     */
    public AppointmentBuilder(Appointment appointmentToCopy) {
        appointmentTime = appointmentToCopy.getAppointmentTime();
        patient = appointmentToCopy.getPatient();
        description = appointmentToCopy.getDescription();
        tags = appointmentToCopy.getTags();
    }

    /**
     * Sets the {@code AppointmentTime} of the {@code Appointment} that we are building.
     */
    public AppointmentBuilder withAppointmentTime(String start, String end) throws ParseException {
        this.appointmentTime = new AppointmentTimeBuilder().withStart(start).withEnd(end).build();
        return this;
    }

    /**
     * Sets the {@code Patient} of the {@code Appointment} that we are building.
     */
    public AppointmentBuilder withPatient(Patient patient){
        this.patient = patient;
        return this;
    }

    /**
     * Sets the {@code Description} of the {@code Appointment} that we are building.
     */
    public AppointmentBuilder withDescription(String description){
        this.description = new Description(description);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Appointment} that we are building.
     */
    public AppointmentBuilder withTags(String ... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    public Appointment build() {
        return new Appointment(appointmentTime, patient, tags, DEFAULT_COMPLETE,DEFAULT_MISSED, description);
    }
}
