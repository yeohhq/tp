package seedu.address.model.appointment;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Iterator;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.appointment.exceptions.DuplicateAppointmentException;
import seedu.address.model.appointment.exceptions.AppointmentNotFoundException;
import seedu.address.model.patient.Patient;

/**
 * A list of appointments that enforces uniqueness between its elements and does not allow nulls.
 * An appointment is considered unique by comparing using {@code Appointment#isSameAppointment(Appointment)}.
 * As such, adding and updating of appointments uses Appointment#isSameAppointment(Appointment)
 * for equality so as to ensure that the patient being added or updated is
 * unique in terms of identity in the UniquePatientList.
 * However, the removal of a patient uses Patient#equals(Object) so
 * as to ensure that the patient with exactly the same fields will be removed.
 *
 * Supports a minimal set of list operations.
 *
 * @see Patient#isSamePatient(Patient)
 */
public class AppointmentList {
}
