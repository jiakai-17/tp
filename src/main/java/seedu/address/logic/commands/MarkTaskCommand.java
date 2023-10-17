package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.task.*;

/**
 * Marks the status of an existing task in the task list as done.
 */
public class MarkTaskCommand extends Command {

    public static final String COMMAND_WORD = "markTask";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Mark status as done for the task specified "
            + "by the index number used in the displayed task list.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 1 ";

    public static final String MESSAGE_MARK_TASK_SUCCESS = "Marked Task as Done: %1$s";
    public static final String MESSAGE_HAS_BEEN_MARKED = "This task is already marked as done in the task list.";

    private final Index index;
    /**
     * Status flag for done tasks.
     * It is set to {@code true} to indicate tasks that are done.
     */
    private final static Status STATUS = new Status("true");

    /**
     * @param index of the task in the filtered task list to mark as done
     */
    public MarkTaskCommand(Index index) {
        requireNonNull(index);

        this.index = index;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Task> lastShownList = model.getFilteredTaskList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_TASK_DISPLAYED_INDEX);
        }

        Task taskToMark = lastShownList.get(index.getZeroBased());

        if (taskToMark.getStatus().equals(STATUS)) {
            throw new CommandException(MESSAGE_HAS_BEEN_MARKED);
        }

        model.markTask(taskToMark);
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
        return new CommandResult(String.format(MESSAGE_MARK_TASK_SUCCESS, Messages.format(taskToMark)));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof MarkTaskCommand)) {
            return false;
        }

        MarkTaskCommand otherMarkTaskCommand = (MarkTaskCommand) other;
        return index.equals(otherMarkTaskCommand.index);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("targetIndex", index)
                .toString();
    }
}

