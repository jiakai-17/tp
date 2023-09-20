package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class RemarkTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Remark(null));
    }

    @Test
    public void equals() {
        Remark validRemark = new Remark("Valid Remark");

        // same values -> returns true
        assertTrue(validRemark.equals(new Remark("Valid Remark")));

        // same object -> returns true
        assertTrue(validRemark.equals(validRemark));

        // null -> returns false
        assertFalse(validRemark.equals(null));

        // different types -> returns false
        assertFalse(validRemark.equals(5.0f));

        // different values -> returns false
        assertFalse(validRemark.equals(new Remark("Other Valid Remark")));
    }
}
