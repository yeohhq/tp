package seedu.address.commons;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.TypicalPatients.ALICE;
import static seedu.address.testutil.TypicalPatients.getTypicalAddressBook;

import java.nio.file.Path;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import seedu.address.logic.Logic;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.commands.patientcommands.PatientAddCommand;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;




public class UserHistoryManagerTest {
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
     * Test if the program starts its previously stored data in its history
     */
    @Test
    public void testInitialiseWithPreviousHistory() {
        assertEquals(model.getUserHistoryManager().getUserHistorySize(), 1);
    }

    @Test
    public void testAddHistory() throws CommandException {
        CommandResult commandResultOne = new PatientAddCommand(ALICE).execute(model);
        int size = model.getUserHistoryManager().getUserHistorySize();
        assertEquals(size, 2);
    }

    @Test
    public void testUndoHistory() throws CommandException {
        CommandResult commandResultOne = new PatientAddCommand(ALICE).execute(model);
        int sizeBefore = model.getUserHistoryManager().getUserHistorySize();
        model.getUserHistoryManager().undoHistory();
        int sizeAfter = model.getUserHistoryManager().getUserHistorySize();
        assertEquals(sizeBefore, 2);
        assertEquals(sizeBefore - 1, sizeAfter);
    }

    @Test
    public void getHistoryTest() {
        assertEquals(model.getUserHistoryManager().getHistory().get(0),
                model.getAddressBook().getPatientList());
    }
}
