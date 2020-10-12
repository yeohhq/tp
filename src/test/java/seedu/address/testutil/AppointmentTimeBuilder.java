package seedu.address.testutil;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import com.fasterxml.jackson.databind.ser.impl.FailingSerializer;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.model.appointment.AppointmentTime;
import seedu.address.model.patient.Name;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * A utility class to help with building AppointmentTime objects.
 */
public class AppointmentTimeBuilder {

    /**
     * Formats date and time inputs as: yyyy-MM-dd hh:mm (eg. 2020-02-20 08:00).
     */
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm");

    public static final String DEFAULT_START = "2020-01-01 12:00";
    public static final String DEFAULT_END = "2020-01-01 14:00";

    public LocalDateTime start;
    public LocalDateTime end;

    /**
     * Creates a {@code AppointmentTimeBuilder} with the default details.
     */
    public AppointmentTimeBuilder() {
        start = parseDateTime(DEFAULT_START);
        end = parseDateTime(DEFAULT_END);
    }

    /**
     * Initializes the AppointmentTimeBuilder with the data of {@code appointmentTimeToCopy}.
     */
    public AppointmentTimeBuilder(AppointmentTime appointmentTimeToCopy) {
        start = appointmentTimeToCopy.getStart();
        end = appointmentTimeToCopy.getEnd();
    }

    /**
     * Sets the start time of the {@code AppointmentTime} that we are building.
     */
    public AppointmentTimeBuilder withStart(String stringStart) {
        this.start = parseDateTime(stringStart);
        return this;
    }

    /**
     * Sets the end time of the {@code AppointmentTime} that we are building.
     */
    public AppointmentTimeBuilder withEnd(String stringEnd) {
        this.end = parseDateTime(stringEnd);
        return this;
    }

    public AppointmentTime build() {
        return new AppointmentTime(start, end);
    }

    /**
     * Parses a {@code String dateTime} into a {@code LocalDateTime}.
     * Leading and trailing whitespaces will be trimmed.
     */
    /*
    public static LocalDateTime parseDateTime(String dateTime) {
        requireNonNull(dateTime);
        String trimmedDateTime = dateTime.trim();
        LocalDateTime localDateTime = null;
        localDateTime = LocalDateTime.parse(trimmedDateTime, DATE_FORMATTER);
        return localDateTime;
    }

     */
    public static LocalDateTime parseDateTime(String dateTime) {
        requireNonNull(dateTime);
        LocalDateTime localDateTime = null;
        String[] dateTimeSplit = dateTime.split(" ", 2);
        String date = dateTimeSplit[0];
        String time = dateTimeSplit[1];
        String[] dateSplit = date.split("-", 3);
        int year = Integer.parseInt(dateSplit[0]);
        int month = Integer.parseInt(dateSplit[1]);
        int day = Integer.parseInt(dateSplit[2]);
        String[] timeSplit = time.split(":", 2);
        int hour = Integer.parseInt(timeSplit[0]);
        int min = Integer.parseInt(timeSplit[1]);
        //String dt = date + "T" + time;
        localDateTime = LocalDateTime.of(year, month, day, hour, min);
        return localDateTime;
    }
}
