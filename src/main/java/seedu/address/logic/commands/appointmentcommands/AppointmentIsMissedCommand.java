package seedu.address.logic.commands.appointmentcommands;

import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.model.Model;
import seedu.address.model.filters.appointmentfilters.SearchAppointmentMissedFilter;
import seedu.address.model.filters.appointmentfilters.SearchPatientFilter;

import static java.util.Objects.requireNonNull;

/**
 * Finds and lists all appointments missed appointments in the addressbook.
 */
public class AppointmentIsMissedCommand extends Command {

    public static final String COMMAND_WORD = "a-missed";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all missed appointments. "
            + "\n"
            + "Example: " + COMMAND_WORD;

    private final SearchAppointmentMissedFilter predicate;

    public AppointmentIsMissedCommand(SearchAppointmentMissedFilter predicate) {
        this.predicate = predicate;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredAppointmentList(predicate);
        return new CommandResult(
                String.format(Messages.MESSAGE_PATIENTS_LISTED_OVERVIEW, model.getFilteredAppointmentList().size()));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AppointmentIsMissedCommand // instanceof handles nulls
                && predicate.equals(((AppointmentIsMissedCommand) other).predicate)); // state check
    }
}
