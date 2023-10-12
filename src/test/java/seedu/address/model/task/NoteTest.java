package seedu.address.model.task;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class NoteTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Note(null));
    }

    @Test
    public void constructor_invalidNote_throwsIllegalArgumentException() {
        String invalidName = "";
        assertThrows(IllegalArgumentException.class, () -> new Note(invalidName));
    }

    @Test
    public void isValidNote() {
        // null name
        assertThrows(NullPointerException.class, () -> Note.isValidNote(null));

        // invalid name
        assertFalse(Note.isValidNote("")); // empty string
        assertFalse(Note.isValidNote(" ")); // spaces only
        assertFalse(Note.isValidNote("^")); // only non-alphanumeric characters
        assertFalse(Note.isValidNote("SELECT*")); // contains non-alphanumeric characters

        // valid name
        assertTrue(Note.isValidNote("do work")); // alphabets only
        assertTrue(Note.isValidNote("12345")); // numbers only
        assertTrue(Note.isValidNote("submit by the 2nd")); // alphanumeric characters
        assertTrue(Note.isValidNote("CS2103")); // with capital letters
        assertTrue(Note.isValidNote("CoordiMate for Event Planners of CS2103")); // long names
    }

    @Test
    public void equals() {
        Note note = new Note("Valid Note");

        // same values -> returns true
        assertTrue(note.equals(new Note("Valid Note")));

        // same object -> returns true
        assertTrue(note.equals(note));

        // null -> returns false
        assertFalse(note.equals(null));

        // different types -> returns false
        assertFalse(note.equals(5.0f));

        // different values -> returns false
        assertFalse(note.equals(new Note("Other Valid Note")));
    }
}
