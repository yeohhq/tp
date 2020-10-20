package seedu.address.logic.parser.appointmentparser;

import seedu.address.logic.commands.appointmentcommands.AppointmentListCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new AppointmentListCommand object
 */
public class AppointmentListCommandParser implements Parser<AppointmentListCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the AppointmentListCommand
     * and returns a AppointmentListCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public AppointmentListCommand parse(String args) {
        return new AppointmentListCommand();
    }
}
