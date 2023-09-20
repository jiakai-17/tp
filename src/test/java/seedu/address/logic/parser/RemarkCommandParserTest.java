package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.RemarkCommand;
import seedu.address.model.person.Remark;

public class RemarkCommandParserTest {

    private final RemarkCommandParser parser = new RemarkCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, RemarkCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validArgs_returnsRemarkCommand() {
        RemarkCommand expectedRemarkCommand =
                new RemarkCommand(Index.fromOneBased(1), new Remark("REMARK STUB"));

        assertParseSuccess(parser, "1 r/ REMARK STUB", expectedRemarkCommand);
    }

}
