package seedu.address.logic.commands.appointmentcommands;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_APPOINTMENT_DISPLAYED_INDEX;

import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.appointment.Appointment;

/**
 * Sets an existing appointment in the address book as completed.
 */
public class AppointmentCompleteCommand extends Command {
    public static final String COMMAND_WORD = "a-complete";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sets an appointment as completed "
            + "by the index number used in the displayed appointment list.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + "Example: " + COMMAND_WORD + " 1 ";

    public static final String MESSAGE_COMPLETE_APPOINTMENT_SUCCESS = "Completed Appointment: %1$s";
    public static final String MESSAGE_DUPLICATE_COMPLETE = "This appointment has already been completed.";

    private final Index targetIndex;

    /**
     * @param targetIndex of the appointment in the filtered appointment list to set as completed
     */
    public AppointmentCompleteCommand(Index targetIndex) {
        requireNonNull(targetIndex);

        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Appointment> lastShownList = model.getFilteredAppointmentList();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(MESSAGE_INVALID_APPOINTMENT_DISPLAYED_INDEX);
        }

        Appointment appointmentToComplete = lastShownList.get(targetIndex.getZeroBased());

        model.completeAppointment(appointmentToComplete);
        return new CommandResult(String.format(MESSAGE_COMPLETE_APPOINTMENT_SUCCESS, appointmentToComplete));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AppointmentCompleteCommand // instanceof handles nulls
                && targetIndex.equals(((AppointmentCompleteCommand) other).targetIndex)); // state check
    }
}
