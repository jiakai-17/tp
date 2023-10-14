package seedu.address.testutil;

import seedu.address.model.task.Note;
import seedu.address.model.task.Task;
import seedu.address.model.task.Title;

/**
 * A utility class to help with building Task objects.
 */
public class TaskBuilder {

    public static final String DEFAULT_TITLE = "Do Something";
    public static final String DEFAULT_NOTE = "For CS2103T";

    private Title title;
    private Note note;

    /**
     * Creates a {@code TaskBuilder} with the default details.
     */
    public TaskBuilder() {
        title = new Title(DEFAULT_TITLE);
        note = new Note(DEFAULT_NOTE);
    }

    /**
     * Initializes the TaskBuilder with the data of {@code taskToCopy}.
     */
    public TaskBuilder(Task taskToCopy) {
        title = taskToCopy.getTitle();
        note = taskToCopy.getNote();
    }

    /**
     * Sets the {@code Title} of the {@code Task} that we are building.
     */
    public TaskBuilder withTitle(String title) {
        this.title = new Title(title);
        return this;
    }

    /**
     * Sets the {@code Note} of the {@code Task} that we are building.
     */
    public TaskBuilder withNote(String note) {
        this.note = new Note(note);
        return this;
    }

    public Task build() {
        return new Task(title, note);
    }

}
