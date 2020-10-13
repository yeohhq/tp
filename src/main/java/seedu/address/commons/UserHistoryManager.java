package seedu.address.commons;

import java.util.List;
import java.util.Stack;

import javafx.util.Pair;
import seedu.address.model.appointment.Appointment;
import seedu.address.model.patient.Patient;

public class UserHistoryManager {

    private final Stack<Pair<List<Patient>, List<Appointment>>> userHistory;

    public UserHistoryManager() {
        this.userHistory = new Stack<>();
    }

    public void addHistory(Pair p) {
        userHistory.add(p);
    }



    public void undoHistory() {
        userHistory.pop();
    }

    public int getUserHistorySize() {
        return userHistory.size();
    }

    public Stack<Pair<List<Patient>, List<Appointment>>> getHistory() {
        return userHistory;
    }

    public boolean canUndo() {
        return userHistory.size() > 1;
    }



}
