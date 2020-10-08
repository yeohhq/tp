package seedu.address.storage;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.model.appointment.Appointment;
import seedu.address.model.appointment.AppointmentTime;
import seedu.address.model.appointment.Description;
import seedu.address.model.patient.Patient;
import seedu.address.model.tag.Tag;

/**
 * Jackson-friendly version of {@link Appointment}.
 */
public class JsonAdaptedAppointment {

    // TODO: Implement this class to handle Patient storage and retrieval.

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Appointment's %s field is missing!";

    private final String appointmentTime;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private final String patient;
    private final String description;
    private final String isCompleted;
    private final String isMissed;
    private final List<JsonAdaptedTag> tagged = new ArrayList<>();
    private List<Patient> patientList = new ArrayList<>();

    /**
     * Constructs a {@code JsonAdaptedAppointment} with the given appointment details.
     */
    @JsonCreator
    public JsonAdaptedAppointment(@JsonProperty("appointmentTime") String appointmentTime,
                                  @JsonProperty("patient") String patient,
                                  @JsonProperty("description") String description,
                                  @JsonProperty("isCompleted") String isCompleted,
                                  @JsonProperty("isMissed") String isMissed,
                                  @JsonProperty("tagged") List<JsonAdaptedTag> tagged) {
        this.appointmentTime = appointmentTime;
        this.patient = patient;
        this.description = description;
        this.isCompleted = isCompleted;
        this.isMissed = isMissed;
        if (tagged != null) {
            this.tagged.addAll(tagged);
        }
    }

    /**
     * Converts a given {@code Appointment} into this class for Jackson use.
     */
    public JsonAdaptedAppointment(Appointment source, ArrayList<Patient> patientList) {
        appointmentTime = source.getAppointmentTime().toString();
        patient = source.getPatient().toString();
        description = source.getDescription().toString();
        isCompleted = source.isCompleted().toString();
        isMissed = source.isMissed().toString();
        tagged.addAll(source.getTags().stream()
                .map(JsonAdaptedTag::new)
                .collect(Collectors.toList()));
        startTime = null;
        endTime = null;
        patientList = patientList;
    }

    /**
     * Converts this Jackson-friendly adapted appointment object into the model's {@code Appointment} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted appointment.
     */
    public Appointment toModelType() throws IllegalValueException {
        final List<Tag> appointmentTags = new ArrayList<>();
        for (JsonAdaptedTag tag : tagged) {
            appointmentTags.add(tag.toModelType());
        }

        if (appointmentTime == null) {
            throw new IllegalValueException(
                    String.format(MISSING_FIELD_MESSAGE_FORMAT, AppointmentTime.class.getSimpleName()));
        }
        try {
            startTime = ParserUtil.parseDateTime(appointmentTime.substring(0, appointmentTime.length() / 2));
            endTime = ParserUtil.parseDateTime(appointmentTime.substring(appointmentTime.length() / 2));

            if (!AppointmentTime.isValidAppointmentTime(startTime, endTime)) {
                throw new IllegalValueException(AppointmentTime.MESSAGE_CONSTRAINTS);
            }
        } catch (DateTimeParseException e) {
            throw new IllegalValueException(AppointmentTime.MESSAGE_CONSTRAINTS);
        }
        final AppointmentTime modelAppointmentTime = new AppointmentTime(startTime, endTime);

        //        if (patient == null) {
        //            throw new IllegalValueException(
        //                    String.format(MISSING_FIELD_MESSAGE_FORMAT, Patient.class.getSimpleName()));
        //        }
        //        if (!Patient.isValidPatient(patient)) {
        //            throw new IllegalValueException(Patient.MESSAGE_CONSTRAINTS);
        //        }
        //        final Patient modelPatient = patientList.get(patient);

        if (description == null) {
            throw new IllegalValueException(
                    String.format(MISSING_FIELD_MESSAGE_FORMAT, Description.class.getSimpleName()));
        }
        if (!Description.isValidDescription(description)) {
            throw new IllegalValueException(Description.MESSAGE_CONSTRAINTS);
        }
        final Description modelDescription = new Description(description);

        if (isCompleted == null || isMissed == null) {
            throw new IllegalValueException(
                    String.format(MISSING_FIELD_MESSAGE_FORMAT, Boolean.class.getSimpleName()));
        }
        final boolean modelisCompleted = Boolean.getBoolean(isCompleted);
        final boolean modelisMissed = Boolean.getBoolean(isMissed);

        final Set<Tag> modelTags = new HashSet<>(appointmentTags);
        //        return new Appointment(modelAppointmentTime, modelPatient, modelTags, modelisCompleted,
        //        modelisMissed, modelDescription);
        return null;
    }

}
