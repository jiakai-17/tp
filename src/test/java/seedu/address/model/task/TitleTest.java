package seedu.address.model.task;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class TitleTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Title(null));
    }

    @Test
    public void constructor_invalidTitle_throwsIllegalArgumentException() {
        String invalidName = "";
        assertThrows(IllegalArgumentException.class, () -> new Title(invalidName));
    }

    @Test
    public void isValidTitle() {
        // null name
        assertThrows(NullPointerException.class, () -> Title.isValidTitle(null));

        // invalid name
        assertFalse(Title.isValidTitle("")); // empty string
        assertFalse(Title.isValidTitle(" ")); // spaces only
        assertFalse(Title.isValidTitle("^")); // only non-alphanumeric characters
        assertFalse(Title.isValidTitle("SELECT*")); // contains non-alphanumeric characters

        // valid name
        assertTrue(Title.isValidTitle("do work")); // alphabets only
        assertTrue(Title.isValidTitle("12345")); // numbers only
        assertTrue(Title.isValidTitle("submit by the 2nd")); // alphanumeric characters
        assertTrue(Title.isValidTitle("CS2103")); // with capital letters
        assertTrue(Title.isValidTitle("CoordiMate for Event Planners of CS2103")); // long names
    }

    @Test
    public void equals() {
        Title title = new Title("Valid Title");

        // same values -> returns true
        assertTrue(title.equals(new Title("Valid Title")));

        // same object -> returns true
        assertTrue(title.equals(title));

        // null -> returns false
        assertFalse(title.equals(null));

        // different types -> returns false
        assertFalse(title.equals(5.0f));

        // different values -> returns false
        assertFalse(title.equals(new Title("Other Valid Title")));
    }
}
