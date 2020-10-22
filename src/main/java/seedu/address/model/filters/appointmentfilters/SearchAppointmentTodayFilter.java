package seedu.address.model.filters.appointmentfilters;

import java.time.LocalDate;
import java.util.function.Predicate;

import seedu.address.model.appointment.Appointment;

/**
 * Filter appointments  {@code Appointment}'s {@code Patient}'s {@code startDate} that matches today's date.
 */
public class SearchAppointmentTodayFilter implements Predicate<Appointment> {
    private LocalDate today;

    public SearchAppointmentTodayFilter() {
        this.today = LocalDate.now();
    }

    @Override
    public boolean test(Appointment appointment) {
        return appointment.getStartTime().toLocalDate().equals(today);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof SearchAppointmentTodayFilter // instanceof handles nulls
                && today.equals(((SearchAppointmentTodayFilter) other).today)); // state check
    }
}
