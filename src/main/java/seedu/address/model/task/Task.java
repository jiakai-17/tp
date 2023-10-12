package seedu.address.model.task;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

import seedu.address.commons.util.ToStringBuilder;

/**
 * Represents a Task in the task list.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Task {

    // Identity field
    private final Title title;
    private final Note note;

    /**
     * Every field must be present and not null.
     */
    public Task(Title title, Note note) {
        requireAllNonNull(title, note);
        this.title = title;
        this.note = note;
    }

    public Title getTitle() {
        return title;
    }

    public Note getNote() {
        return note;
    }

    /**
     * Returns true if both tasks have the same title and note.
     */
    public boolean isSameTask(Task otherTask) {
        return this.equals(otherTask);
    }

    /**
     * Returns true if both tasks have the same title and note.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Task)) {
            return false;
        }

        Task otherTask = (Task) other;
        return title.equals(otherTask.title)
                && note.equals(otherTask.note);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(title, note);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("title", title)
                .add("note", note)
                .toString();
    }

}
