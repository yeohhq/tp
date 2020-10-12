package seedu.address.testutil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.time.LocalDateTime;

import seedu.address.model.appointment.Appointment;
import seedu.address.model.appointment.AppointmentTime;
import seedu.address.model.appointment.Description;
import seedu.address.model.patient.*;

/**
 * A utility class to help with building Appointment objects.
 */
public class AppointmentBuilder {

    public static final LocalDateTime DEFAULT_START = new LocalDateTime("2020-01-01 12:00");
    public static final AppointmentTime DEFAULT_TIME = new AppointmentTime("2020-01-01 12:00", "2020-01-01 14:00");
    public static final Patient DEFAULT_PATIENT = new PatientBuilder().build();
    public static final String DEFAULT_DESCRIPTION = "Appointment";
    public static final boolean DEFAULT_COMPLETE = false;
    public static final boolean DEFAULT_MISSED = false;

    private AppointmentTime

    /**
     * Creates a {@code AppointmentBuilder} with the default details.
     */
    public AppointmentBuilder() {
        name = new Name(DEFAULT_NAME);
        gender = new Gender(DEFAULT_GENDER);
        birthdate = new Birthdate(DEFAULT_BIRTHDATE);
        bloodtype = new BloodType(DEFAULT_BLOODTYPE);
        phone = new Phone(DEFAULT_PHONE);
        email = new Email(DEFAULT_EMAIL);
        address = new Address(DEFAULT_ADDRESS);
        remark = new Remark(DEFAULT_REMARK);
        tags = new HashSet<>();
    }
}
