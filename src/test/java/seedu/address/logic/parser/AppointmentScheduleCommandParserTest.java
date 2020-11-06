package seedu.address.logic.parser;

import static seedu.address.logic.commands.appointmentcommands.AppointmentCommandTestUtil.DESCRIPTION_DESC_ONE;
import static seedu.address.logic.commands.appointmentcommands.AppointmentCommandTestUtil.END_DESC_ONE;
import static seedu.address.logic.commands.appointmentcommands.AppointmentCommandTestUtil.PATIENT_DESC_ONE;
import static seedu.address.logic.commands.appointmentcommands.AppointmentCommandTestUtil.PREAMBLE_WHITESPACE;
import static seedu.address.logic.commands.appointmentcommands.AppointmentCommandTestUtil.START_DESC_ONE;
import static seedu.address.logic.commands.appointmentcommands.AppointmentCommandTestUtil.TAG_DESC_ONE;
import static seedu.address.logic.commands.appointmentcommands.AppointmentCommandTestUtil.VALID_PATIENT_ONE;
import static seedu.address.logic.commands.appointmentcommands.AppointmentCommandTestUtil.VALID_TAG_ONE;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalPatients.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.appointmentcommands.AppointmentScheduleCommand;
import seedu.address.logic.parser.appointmentparser.AppointmentScheduleCommandParser;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.appointment.Appointment;
import seedu.address.testutil.AppointmentBuilder;

public class AppointmentScheduleCommandParserTest {
    private AppointmentScheduleCommandParser parser = new AppointmentScheduleCommandParser();

    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void parse_allFieldsPresent_success() {
        String expectedPatientString = VALID_PATIENT_ONE;

        Appointment expectedAppointment = new AppointmentBuilder()
                            .withPatientString(expectedPatientString)
                            .withTags(VALID_TAG_ONE).buildAppointmentWithPatientString();

        AppointmentScheduleCommand appointmentScheduleCommand = new AppointmentScheduleCommand(expectedAppointment);

        // whitespace only preamble
        assertParseSuccess(parser, PREAMBLE_WHITESPACE + START_DESC_ONE + END_DESC_ONE
                + PATIENT_DESC_ONE + DESCRIPTION_DESC_ONE
                + TAG_DESC_ONE, appointmentScheduleCommand);
        /*
        // multiple names - last name accepted
        assertParseSuccess(parser, NAME_DESC_AMY + NAME_DESC_BOB + GENDER_DESC_BOB
                + BIRTHDATE_DESC_BOB + BLOODTYPE_DESC_BOB
                + PHONE_DESC_BOB + EMAIL_DESC_BOB
                + ADDRESS_DESC_BOB + TAG_DESC_FRIEND, new AppointmentScheduleCommand(expectedAppointment));

        // multiple phones - last phone accepted
        assertParseSuccess(parser, NAME_DESC_BOB + GENDER_DESC_BOB
                + BIRTHDATE_DESC_BOB + BLOODTYPE_DESC_BOB
                + PHONE_DESC_AMY + PHONE_DESC_BOB + EMAIL_DESC_BOB
                + ADDRESS_DESC_BOB + TAG_DESC_FRIEND, new AppointmentScheduleCommand(expectedAppointment));

        // multiple emails - last email accepted
        assertParseSuccess(parser, NAME_DESC_BOB + GENDER_DESC_BOB
                + BIRTHDATE_DESC_BOB + BLOODTYPE_DESC_BOB
                + PHONE_DESC_BOB + EMAIL_DESC_AMY + EMAIL_DESC_BOB
                + ADDRESS_DESC_BOB + TAG_DESC_FRIEND, new AppointmentScheduleCommand(expectedAppointment));

        // multiple addresses - last address accepted
        assertParseSuccess(parser, NAME_DESC_BOB + GENDER_DESC_BOB
                + BIRTHDATE_DESC_BOB + BLOODTYPE_DESC_BOB
                + PHONE_DESC_BOB + EMAIL_DESC_BOB + ADDRESS_DESC_AMY
                + ADDRESS_DESC_BOB + TAG_DESC_FRIEND, new AppointmentScheduleCommand(expectedAppointment));

        // multiple tags - all accepted
        Appointment expectedAppointmentMultipleTags = new AppointmentBuilder(BOB)
            .withTags(VALID_TAG_FRIEND, VALID_TAG_HUSBAND).build();

        assertParseSuccess(parser, NAME_DESC_BOB + GENDER_DESC_BOB
                + BIRTHDATE_DESC_BOB + BLOODTYPE_DESC_BOB
                + PHONE_DESC_BOB + EMAIL_DESC_BOB + ADDRESS_DESC_BOB
                + TAG_DESC_HUSBAND + TAG_DESC_FRIEND, new AppointmentScheduleCommand(expectedAppointmentMultipleTags));

        */
    }


}
