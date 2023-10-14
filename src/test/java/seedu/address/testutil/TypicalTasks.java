package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.task.Task;

/**
 * A utility class containing a list of {@code Person} objects to be used in tests.
 */
public class TypicalTasks {

    public static final Task AGENDA = new TaskBuilder()
            .withTitle("Prepare Agenda")
            .withNote("To book venue")
            .build();

    public static final Task BUDGET = new TaskBuilder()
            .withTitle("Prepare Budget")
            .withNote("For CS2102")
            .build();

    public static final Task CATERING = new TaskBuilder()
            .withTitle("Book Catering")
            .withNote("For CS2101")
            .build();

    public static final Task DRAFT = new TaskBuilder()
            .withTitle("Send Budget and Draft")
            .withNote("For CS2100")
            .build();

    public static final Task ENTERTAINMENT = new TaskBuilder()
            .withTitle("Book Entertainment")
            .withNote("For CS1101")
            .build();

    public static final Task FUNDING = new TaskBuilder()
            .withTitle("Prepare Funding")
            .withNote("For MA2001")
            .build();

    public static final Task GUESTLIST = new TaskBuilder()
            .withTitle("Prepare Guestlist")
            .withNote("For CS2103T")
            .build();

    public static final Task HOSPITALITY = new TaskBuilder()
            .withTitle("Ensure Hospitality")
            .withNote("For CS2103T")
            .build();

    public static final Task INVITATION = new TaskBuilder()
            .withTitle("Send Invitations and Guestlist")
            .withNote("For CS2103T")
            .build();

    // Keywords
    public static final String KEYWORD_MATCHING_BOOK = "Book";
    public static final String KEYWORD_MATCHING_PREPARE = "Prepare";
    public static final String KEYWORD_MATCHING_SEND = "Send";
    public static final String KEYWORD_MATCHING_FOR = "For";
    public static final String KEYWORD_MATCHING_CS2103T = "CS2103T";

    private TypicalTasks() {
    } // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical task.
     */
    public static AddressBook getTypicalTaskList() {
        AddressBook ab = new AddressBook();
        for (Task task : getTypicalTasks()) {
            ab.addTask(task);
        }
        return ab;
    }

    public static List<Task> getTypicalTasks() {
        return new ArrayList<>(Arrays.asList(AGENDA, BUDGET, CATERING, DRAFT, ENTERTAINMENT, FUNDING, GUESTLIST,
                HOSPITALITY, INVITATION));
    }
}
