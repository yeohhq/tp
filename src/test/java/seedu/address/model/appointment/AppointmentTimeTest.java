package seedu.address.model.appointment;

import org.junit.jupiter.api.Test;
;
import static seedu.address.testutil.Assert.assertThrows;

public class AppointmentTimeTest {
    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new AppointmentTime(null, null));
    }
}
