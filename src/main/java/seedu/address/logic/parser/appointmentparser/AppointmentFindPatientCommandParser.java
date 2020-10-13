package seedu.address.logic.parser.appointmentparser;

import seedu.address.logic.commands.appointmentcommands.AppointmentFindPatientCommand;
import seedu.address.logic.commands.patientcommands.PatientFindCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.filters.appointmentfilters.SearchPatientFilter;
import seedu.address.model.filters.patientfilters.SearchNameFilter;

import java.util.Arrays;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

/**
 * Parses input arguments and creates a new PatientFindCommand object
 */
public class AppointmentFindPatientCommandParser implements Parser<AppointmentFindPatientCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the PatientFindCommand
     * and returns a PatientFindCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public AppointmentFindPatientCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, PatientFindCommand.MESSAGE_USAGE));
        }

        String[] nameKeywords = trimmedArgs.split("\\s+");

        return new AppointmentFindPatientCommand(new SearchPatientFilter(Arrays.asList(nameKeywords)));
    }

}
