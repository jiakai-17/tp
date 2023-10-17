package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.CommandTestUtil.showPersonAtIndex;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_PERSON;
import static seedu.address.testutil.TypicalTasks.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.task.*;

/**
 * Contains integration tests (interaction with the Model) and unit tests for
 * {@code MarkTaskCommand}.
 */
public class MarkTaskCommandTest {

    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void execute_validIndexUnfilteredList_success() {
        Task taskToMark = model.getFilteredTaskList().get(INDEX_FIRST_PERSON.getZeroBased());
        MarkTaskCommand markTaskCommand = new MarkTaskCommand(INDEX_FIRST_PERSON);

        String expectedMessage = String.format(markTaskCommand.MESSAGE_MARK_TASK_SUCCESS,
                Messages.format(taskToMark));

        ModelManager expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
        expectedModel.markTask(taskToMark);

        assertCommandSuccess(markTaskCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_invalidIndexUnfilteredList_throwsCommandException() {
        Index outOfBoundIndex = Index.fromOneBased(model.getFilteredPersonList().size() + 1);
        MarkTaskCommand markTaskCommand = new MarkTaskCommand(outOfBoundIndex);

        assertCommandFailure(markTaskCommand, model, Messages.MESSAGE_INVALID_TASK_DISPLAYED_INDEX);
    }

    @Test
    public void execute_validIndexFilteredList_success() {
        showPersonAtIndex(model, INDEX_FIRST_PERSON);

        Task taskToMark = model.getFilteredTaskList().get(INDEX_FIRST_PERSON.getZeroBased());
        MarkTaskCommand markTaskCommand = new MarkTaskCommand(INDEX_FIRST_PERSON);

        String expectedMessage = String.format(MarkTaskCommand.MESSAGE_MARK_TASK_SUCCESS,
                Messages.format(taskToMark));

        Model expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
        expectedModel.markTask(taskToMark);

        assertCommandSuccess(markTaskCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_invalidIndexFilteredList_throwsCommandException() {
        showPersonAtIndex(model, INDEX_FIRST_PERSON);

        Index outOfBoundIndex = INDEX_SECOND_PERSON;
        // ensures that outOfBoundIndex is still in bounds of address book list
        assertTrue(outOfBoundIndex.getZeroBased() < model.getAddressBook().getPersonList().size());

        MarkTaskCommand markTaskCommand = new MarkTaskCommand(outOfBoundIndex);

        assertCommandFailure(markTaskCommand, model, Messages.MESSAGE_INVALID_TASK_DISPLAYED_INDEX);
    }

    @Test
    public void equals() {
        MarkTaskCommand markTaskFirstCommand = new MarkTaskCommand(INDEX_FIRST_PERSON);
        MarkTaskCommand markTaskSecondCommand = new MarkTaskCommand(INDEX_SECOND_PERSON);

        // same object -> returns true
        assertTrue(markTaskFirstCommand.equals(markTaskFirstCommand));

        // same values -> returns true
        MarkTaskCommand markTaskFirstCommandCopy = new MarkTaskCommand(INDEX_FIRST_PERSON);
        assertTrue(markTaskFirstCommand.equals(markTaskFirstCommandCopy));

        // different types -> returns false
        assertFalse(markTaskFirstCommand.equals(1));

        // null -> returns false
        assertFalse(markTaskFirstCommand.equals(null));

        // different person -> returns false
        assertFalse(markTaskFirstCommand.equals(markTaskSecondCommand));
    }

    @Test
    public void toStringMethod() {
        Index targetIndex = Index.fromOneBased(1);
        MarkTaskCommand markTaskCommand = new MarkTaskCommand(targetIndex);
        String expected = MarkTaskCommand.class.getCanonicalName() + "{targetIndex=" + targetIndex + "}";
        assertEquals(expected, markTaskCommand.toString());
    }
}
