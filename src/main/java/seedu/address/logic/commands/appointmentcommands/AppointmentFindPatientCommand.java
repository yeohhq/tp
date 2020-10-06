package seedu.address.logic.commands.appointmentcommands;

import seedu.address.model.filters.appointmentfilters.SearchPatientFilter;

public class AppointmentFindPatientCommand {

    public static final String COMMAND_WORD = "p-find";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all appointments with patients whose names "
            + "contain any of the specified keywords (case-insensitive) and displays them as a list with index "
            + "numbers.\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + " alice bob charlie";

    private final SearchPatientFilter predicate;

    public AppointmentFindPatientCommand(SearchPatientFilter predicate) {
        this.predicate = predicate;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AppointmentFindPatientCommand // instanceof handles nulls
                && predicate.equals(((AppointmentFindPatientCommand) other).predicate)); // state check
    }
}
