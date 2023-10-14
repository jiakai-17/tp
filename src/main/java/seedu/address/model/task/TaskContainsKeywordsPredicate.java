package seedu.address.model.task;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;
import seedu.address.commons.util.ToStringBuilder;

/**
 * Tests that a {@code Task}'s {@code Title} or {@code Note} matches any of the keywords given.
 */
public class TaskContainsKeywordsPredicate implements Predicate<Task> {
    private final List<String> keywords;

    public TaskContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Task task) {
        return keywords
                .stream()
                .anyMatch(keyword -> {
                    String taskTitleAndNote = task.getTitle().taskTitle + " " + task.getNote().taskNote;
                    return StringUtil.containsWordIgnoreCase(taskTitleAndNote, keyword);
                });
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof TaskContainsKeywordsPredicate)) {
            return false;
        }

        TaskContainsKeywordsPredicate otherTaskContainsKeywordsPredicate = (TaskContainsKeywordsPredicate) other;
        return keywords.equals(otherTaskContainsKeywordsPredicate.keywords);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).add("keywords", keywords).toString();
    }
}
