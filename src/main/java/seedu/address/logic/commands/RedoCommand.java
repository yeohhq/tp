package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

public class RedoCommand extends Command {

    public static final String COMMAND_WORD = "redo";

    public static final String MESSAGE_SUCCESS = "Command redone.";
    public static final String MESSAGE_NO_UNDO_HISTORY_ERROR = "Nothing to redo!";

    @Override
    public CommandResult execute(Model model) throws CommandException {
        if (!model.getUserHistoryManager().canRedo()) {
            throw new CommandException(MESSAGE_NO_UNDO_HISTORY_ERROR);
        } else {
            model.redoHistory();
            return new CommandResult("Command redone.", false, false, false);
        }
    }
}
