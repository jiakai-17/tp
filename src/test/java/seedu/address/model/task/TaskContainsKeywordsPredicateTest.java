package seedu.address.model.task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.TaskBuilder;

public class TaskContainsKeywordsPredicateTest {

    @Test
    public void equals() {
        List<String> firstPredicateKeywordList = Collections.singletonList("first");
        List<String> secondPredicateKeywordList = Arrays.asList("first", "second");

        TaskContainsKeywordsPredicate firstPredicate =
                new TaskContainsKeywordsPredicate(firstPredicateKeywordList);
        TaskContainsKeywordsPredicate secondPredicate =
                new TaskContainsKeywordsPredicate(secondPredicateKeywordList);

        // same object -> returns true
        assertEquals(firstPredicate, firstPredicate);

        // same values -> returns true
        TaskContainsKeywordsPredicate firstPredicateCopy =
                new TaskContainsKeywordsPredicate(firstPredicateKeywordList);
        assertEquals(firstPredicate, firstPredicateCopy);

        // different types -> returns false
        assertNotEquals(1, firstPredicate);
        assertFalse(firstPredicate.equals(1));

        // null -> returns false
        assertNotEquals(null, firstPredicate);

        // different values -> returns false
        assertNotEquals(firstPredicate, secondPredicate);
    }

    @Test
    public void test_taskContainsKeywords_returnsTrue() {
        // One keyword
        TaskContainsKeywordsPredicate predicate =
                new TaskContainsKeywordsPredicate(Collections.singletonList("Bob"));
        assertTrue(predicate.test(new TaskBuilder().withTitle("Alice Bob").withNote("Charlie").build()));
        assertTrue(predicate.test(new TaskBuilder().withTitle("Charlie").withNote("Alice Bob").build()));

        // Multiple keywords
        predicate = new TaskContainsKeywordsPredicate(Arrays.asList("Alice", "Bob"));
        assertTrue(predicate.test(new TaskBuilder().withTitle("Carol").withNote("Alice Bob").build()));
        assertTrue(predicate.test(new TaskBuilder().withTitle("Alice Bob").withNote("Carol").build()));
        assertTrue(predicate.test(new TaskBuilder().withTitle("Alice Bob Carol").withNote("Derrick").build()));
        assertTrue(predicate.test(new TaskBuilder().withTitle("Derrick").withNote("Alice Bob Carol").build()));

        // Only one matching keyword
        predicate = new TaskContainsKeywordsPredicate(Arrays.asList("Bob", "Carol"));
        assertTrue(predicate.test(new TaskBuilder().withTitle("Derrick").withNote("Alice Bob").build()));
        assertTrue(predicate.test(new TaskBuilder().withTitle("Alice Bob").withNote("Derrick").build()));

        // Mixed-case keywords
        predicate = new TaskContainsKeywordsPredicate(Arrays.asList("aLIce", "bOB"));
        assertTrue(predicate.test(new TaskBuilder().withTitle("Derrick Alice Echo Bob").withNote("Carol").build()));
        assertTrue(predicate.test(new TaskBuilder().withTitle("Carol").withNote("Derrick Alice Echo Bob").build()));
    }

    @Test
    public void test_nameDoesNotContainKeywords_returnsFalse() {
        // Zero keywords
        TaskContainsKeywordsPredicate predicate = new TaskContainsKeywordsPredicate(Collections.emptyList());
        assertFalse(predicate.test(new TaskBuilder().withTitle("Alice").withNote("Bob").build()));

        // Non-matching keyword
        predicate = new TaskContainsKeywordsPredicate(Collections.singletonList("Carol"));
        assertFalse(predicate.test(new TaskBuilder().withTitle("Alice").withNote("Bob").build()));
    }

    @Test
    public void toStringMethod() {
        List<String> keywords = List.of("keyword1", "keyword2");
        TaskContainsKeywordsPredicate predicate = new TaskContainsKeywordsPredicate(keywords);

        String expected = TaskContainsKeywordsPredicate.class.getCanonicalName() + "{keywords=" + keywords + "}";
        assertEquals(expected, predicate.toString());
    }
}
