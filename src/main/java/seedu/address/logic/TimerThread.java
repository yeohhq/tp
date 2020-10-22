package seedu.address.logic;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.exceptions.ParseException;

public class TimerThread extends Thread {

    private Logic logic;
    private Boolean running;

    public TimerThread(Logic logic) {
        this.logic = logic;
        this.running = true;
    }

    public void run() {
        while (running) {
            try {
                logic.execute("a-new-misses");
            } catch (CommandException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void setStop() {
        this.running = false;
    }
}
