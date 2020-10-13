package seedu.address.logic.commands.appointmentcommands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_APPOINTMENT_END;
import static seedu.address.logic.parser.CliSyntax.PREFIX_APPOINTMENT_START;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PATIENT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.appointment.Appointment;

/**
 * Adds an appointment to the address book.
 */
public class AppointmentScheduleCommand extends Command {

    public static final String COMMAND_WORD = "a-schedule";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Schedules an appointment to Archangel."
            + "Parameters: "
            + PREFIX_APPOINTMENT_START + "START "
            + PREFIX_APPOINTMENT_END + "END "
            + PREFIX_PATIENT + "PATIENT "
            + PREFIX_DESCRIPTION + "BLOOD_TYPE "
            + "[" + PREFIX_TAG + "TAG]...\n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_APPOINTMENT_START + "2020-01-25 08:00 "
            + PREFIX_APPOINTMENT_END + "2020-01-25 12:00 "
            + PREFIX_PATIENT + "John Doe "
            + PREFIX_DESCRIPTION + "Medical checkup "
            + PREFIX_TAG + "LowPriority";

    public static final String MESSAGE_SUCCESS = "New appointment scheduled: %1$s";
    public static final String MESSAGE_DUPLICATE_APPOINTMENT = "This appointment already exists in Archangel";
    public static final String MESSAGE_MISSING_PATIENT = "This patient is not in Archangel";

    private final Appointment toSchedule;

    /**
     * Creates an AppointmentAddCommand to add the specified {@code Appointment}
     */
    public AppointmentScheduleCommand(Appointment appointment) {
        requireNonNull(appointment);
        toSchedule = appointment;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        toSchedule.parsePatient(model.getAddressBook());
        if (!model.hasPatient(toSchedule.getPatient())) {
            throw new CommandException((MESSAGE_MISSING_PATIENT));
        }
        if (model.hasAppointment(toSchedule)) {
            throw new CommandException(MESSAGE_DUPLICATE_APPOINTMENT);
        }
        model.addAppointment(toSchedule);
        return new CommandResult(String.format(MESSAGE_SUCCESS, toSchedule));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AppointmentScheduleCommand // instanceof handles nulls
                && toSchedule.equals(((AppointmentScheduleCommand) other).toSchedule));
    }
}
