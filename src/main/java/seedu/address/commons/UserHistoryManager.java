package seedu.address.commons;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import seedu.address.model.patient.Patient;

public class UserHistoryManager {

    private final Stack<List<Patient>> userHistory;

    public UserHistoryManager() {
        this.userHistory = new Stack<>();
    }

    public void addHistory(List<Patient> newList) {
        userHistory.add(new ArrayList<>(newList));
    }

    public void undoHistory() {
        userHistory.pop();
    }

    public int getUserHistorySize() {
        return userHistory.size();
    }

    public Stack<List<Patient>> getHistory() {
        return userHistory;
    }

    public boolean canUndo() {
        return userHistory.size() > 1;
    }



}
