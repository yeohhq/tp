package seedu.address.logic.commands.appointmentcommands;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

public class AppointmentListCommand extends Command {

    public static final String COMMAND_WORD = "a-list";

    public static final String MESSAGE_USAGE = COMMAND_WORD;

    @Override
    public CommandResult execute(Model model) throws CommandException {
        return new CommandResult("List command");
    }
}
