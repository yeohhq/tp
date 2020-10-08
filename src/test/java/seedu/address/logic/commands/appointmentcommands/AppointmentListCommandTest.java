package seedu.address.logic.commands.appointmentcommands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.address.logic.commands.patientcommands.PatientListCommand;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

import static seedu.address.logic.commands.patientcommands.PatientCommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPatients.getTypicalAddressBook;

/**
 * Contains integration tests (interaction with the Model) and unit tests for AppointmentListCommand.
 * NOT DONE
 */
public class AppointmentListCommandTest {

    private Model model;
    private Model expectedModel;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
    }

    @Test
    public void execute_listIsNotFiltered_showsSameList() {
        assertCommandSuccess(new AppointmentListCommand(), model
                , AppointmentListCommand.MESSAGE_LIST_APPOINTMENT_SUCCESS, expectedModel);
    }

    @Test
    public void execute_listIsFiltered_showsEverything() {
        // showAppointmentAtIndex(model, INDEX_FIRST_PATIENT);
        assertCommandSuccess(new PatientListCommand(), model, PatientListCommand.MESSAGE_SUCCESS, expectedModel);
    }
}
