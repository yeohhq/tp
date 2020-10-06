package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.TypicalPatients.ALICE;
import static seedu.address.testutil.TypicalPatients.getTypicalAddressBook;

import java.nio.file.Path;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import seedu.address.commons.UserHistoryManager;
import seedu.address.logic.Logic;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.commands.patientcommands.PatientAddCommand;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.patient.Patient;
import seedu.address.testutil.PatientBuilder;


public class UndoCommandTest {
    @TempDir
    public Path temporaryFolder;

    private Model model = new ModelManager();
    private Logic logic;
    private UserHistoryManager historyManager;

    /**
     * Initialises a dummy ModelManager to aid with testing
     */
    @BeforeEach
    public void setUp() {
        Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    }

    /**
     * Test basic undo functionality
     * @throws CommandException
     */
    @Test
    public void testUndo() throws CommandException {
        Patient validPatient = new PatientBuilder().build();
        CommandResult commandResult = new PatientAddCommand(validPatient).execute(model);
        model.undoPatientHistory();
        assertFalse(model.getAddressBook().getPatientList().contains(validPatient));
    }

    /**
     * Test undo after running multiple commands
     * @throws CommandException
     */
    @Test
    public void testConsecutiveCommandFollowByUndo() throws CommandException {
        Patient validPatientOne = new PatientBuilder().build();
        CommandResult commandResultOne = new PatientAddCommand(validPatientOne).execute(model);
        CommandResult commandResultTwo = new PatientAddCommand(ALICE).execute(model);
        CommandResult undoCommand = new UndoCommand().execute(model);

        assertTrue(model.getAddressBook().getPatientList().contains(validPatientOne));
        assertFalse(model.getAddressBook().getPatientList().contains(ALICE));
    }

    /**
     * Test multiple undo after running multiple commands
     * @throws CommandException
     */
    @Test
    public void testConsecutiveCommandFollowedByConsecutiveUndo() throws CommandException {
        Patient validPatientOne = new PatientBuilder().build();
        CommandResult commandResultOne = new PatientAddCommand(validPatientOne).execute(model);
        CommandResult commandResultTwo = new PatientAddCommand(ALICE).execute(model);
        CommandResult undoCommand = new UndoCommand().execute(model);
        CommandResult undoCommandTwo = new UndoCommand().execute(model);

        assertFalse(model.getAddressBook().getPatientList().contains(validPatientOne));
        assertFalse(model.getAddressBook().getPatientList().contains(ALICE));
    }

    /**
     * Test multiple undo after a single command
     * @throws CommandException
     */
    @Test
    public void testMultipleUndoAfterSingleCommand() throws CommandException {
        Patient validPatientOne = new PatientBuilder().build();
        CommandResult commandResultOne = new PatientAddCommand(validPatientOne).execute(model);

        try {
            CommandResult undoCommand = new UndoCommand().execute(model);
            CommandResult undoCommandTwo = new UndoCommand().execute(model);
        } catch (CommandException e) {
            assertFalse(model.getAddressBook().getPatientList().contains(validPatientOne));
            assertEquals(model.getUserHistoryManager().getUserHistorySize(), 1);
        }
    }

}
