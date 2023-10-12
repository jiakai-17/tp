package seedu.address.model.task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TaskTest {

    private static final Task TEST_TASK_1_1 = new Task(new Title("Test Task 1"), new Note("Test Note 1"));
    private static final Task TEST_TASK_1_1_COPY = new Task(new Title("Test Task 1"), new Note("Test Note 1"));
    private static final Task TEST_TASK_1_2 = new Task(new Title("Test Task 1"), new Note("Test Note 2"));
    private static final Task TEST_TASK_2_1 = new Task(new Title("Test Task 2"), new Note("Test Note 1"));
    private static final Task TEST_TASK_2_2 = new Task(new Title("Test Task 2"), new Note("Test Note 2"));


    @Test
    public void isSameTask() {
        // same values -> returns true
        assertTrue(TEST_TASK_1_1.isSameTask(TEST_TASK_1_1));

        // same object -> returns true
        assertTrue(TEST_TASK_1_1.isSameTask(TEST_TASK_1_1));

        // null -> returns false
        assertFalse(TEST_TASK_1_1.isSameTask(null));

        // same title and note -> returns true
        assertTrue(TEST_TASK_1_1.isSameTask(TEST_TASK_1_1_COPY));

        // different title, same note -> returns false
        assertFalse(TEST_TASK_1_1.isSameTask(TEST_TASK_2_1));

        // same title, different note -> returns false
        assertFalse(TEST_TASK_1_1.isSameTask(TEST_TASK_1_2));
    }

    @Test
    public void equals() {
        // same values -> returns true
        assertTrue(TEST_TASK_1_1.isSameTask(TEST_TASK_1_1));

        // same object -> returns true
        assertTrue(TEST_TASK_1_1.isSameTask(TEST_TASK_1_1));

        // null -> returns false
        assertFalse(TEST_TASK_1_1.isSameTask(null));

        // same title and note -> returns true
        assertTrue(TEST_TASK_1_1.isSameTask(TEST_TASK_1_1_COPY));

        // different title, same note -> returns false
        assertFalse(TEST_TASK_1_1.isSameTask(TEST_TASK_2_1));

        // same title, different note -> returns false
        assertFalse(TEST_TASK_1_1.isSameTask(TEST_TASK_1_2));

        // different type -> returns false
        assertNotEquals(5, TEST_TASK_1_1);

        // different task -> returns false
        assertNotEquals(TEST_TASK_1_1, TEST_TASK_2_2);
    }

    @Test
    public void toStringMethod() {
        String expected = Task.class.getCanonicalName() + "{title=" + TEST_TASK_1_1.getTitle()
                + ", note=" + TEST_TASK_1_1.getNote() + "}";
        assertEquals(expected, TEST_TASK_1_1.toString());
    }
}
