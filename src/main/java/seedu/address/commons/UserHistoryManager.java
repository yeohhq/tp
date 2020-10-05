package seedu.address.commons;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;

import java.util.Stack;
import java.util.concurrent.ConcurrentMap;

public class CommandHistoryManager {

    private final Stack<Command> commandHistory;
    CommandHistoryManager(){

        this.commandHistory = new Stack<>();

    }

    public static final String MESSAGE_NO_UNDO_HISTORY_ERROR = "Nothing to undo!";

    public boolean canUndo() {
        return commandHistory.size() > 0;
    }

    public CommandResult executeUndo() throws CommandException {
        if (!canUndo()) {
            throw new CommandException(MESSAGE_NO_UNDO_HISTORY_ERROR);
        }

        CommandResult cmdResult = commandHistory.peek().
    }

}
