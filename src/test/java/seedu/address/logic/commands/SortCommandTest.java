package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static seedu.address.logic.Messages.MESSAGE_INVALID_CRITERIA_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDED_TIME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_JOB_POSITION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_RATING;
import static seedu.address.logic.parser.CliSyntax.PREFIX_STATUS;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.Prefix;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

public class SortCommandTest {
    private Model model;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    }
    @Test
    public void execute_sortByNameInAscendingOder_success() {
        Prefix prefix = PREFIX_NAME;
        boolean isAscendingOrder = true;
        String order = "ascending order";
        try {
            SortCommand sortCommand = new SortCommand(prefix, isAscendingOrder);
            String expectedMessage = String.format(SortCommand.MESSAGE_SUCCESS,
                    sortCommand.getCriteria(), order);

            Model expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
            expectedModel.sortPersons(prefix, isAscendingOrder);

            assertCommandSuccess(sortCommand, model, expectedMessage, expectedModel);
        } catch (CommandException e) {
            fail();
        }
    }
    @Test
    public void execute_sortByNameInDescendingOder_success() {
        Prefix prefix = PREFIX_NAME;
        boolean isAscendingOrder = false;
        String order = "descending order";
        try {
            SortCommand sortCommand = new SortCommand(prefix, isAscendingOrder);
            String expectedMessage = String.format(SortCommand.MESSAGE_SUCCESS, sortCommand.getCriteria(), order);

            Model expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
            expectedModel.sortPersons(prefix, isAscendingOrder);

            assertCommandSuccess(sortCommand, model, expectedMessage, expectedModel);
        } catch (CommandException e) {
            fail();
        }
    }
    @Test
    public void execute_sortByEmailAddressInAscendingOrder_success() {
        Prefix prefix = PREFIX_EMAIL;
        boolean isAscendingOrder = true;
        String order = "ascending order";
        try {
            SortCommand sortCommand = new SortCommand(prefix, isAscendingOrder);
            String expectedMessage = String.format(SortCommand.MESSAGE_SUCCESS, sortCommand.getCriteria(), order);

            Model expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
            expectedModel.sortPersons(prefix, isAscendingOrder);

            assertCommandSuccess(sortCommand, model, expectedMessage, expectedModel);
        } catch (CommandException e) {
            fail();
        }

    }
    @Test
    public void execute_sortByEmailAddressInDescendingOrder_success() {
        Prefix prefix = PREFIX_EMAIL;
        boolean isAscendingOrder = false;
        String order = "descending order";
        try {
            SortCommand sortCommand = new SortCommand(prefix, isAscendingOrder);
            String expectedMessage = String.format(SortCommand.MESSAGE_SUCCESS, sortCommand.getCriteria(), order);

            Model expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
            expectedModel.sortPersons(prefix, isAscendingOrder);

            assertCommandSuccess(sortCommand, model, expectedMessage, expectedModel);
        } catch (CommandException e) {
            fail();
        }

    }
    @Test
    public void execute_sortByJobPositionInAscendingOrder_success() {
        Prefix prefix = PREFIX_JOB_POSITION;
        boolean isAscendingOrder = true;
        String order = "ascending order";
        try {
            SortCommand sortCommand = new SortCommand(prefix, isAscendingOrder);
            String expectedMessage = String.format(SortCommand.MESSAGE_SUCCESS, sortCommand.getCriteria(), order);

            Model expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
            expectedModel.sortPersons(prefix, isAscendingOrder);

            assertCommandSuccess(sortCommand, model, expectedMessage, expectedModel);
        } catch (CommandException e) {
            fail();
        }

    }
    @Test
    public void execute_sortByJobPositionInDescendingOrder_success() {
        Prefix prefix = PREFIX_JOB_POSITION;
        boolean isAscendingOrder = false;
        String order = "descending order";
        try {
            SortCommand sortCommand = new SortCommand(prefix, isAscendingOrder);
            String expectedMessage = String.format(SortCommand.MESSAGE_SUCCESS, sortCommand.getCriteria(), order);

            Model expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
            expectedModel.sortPersons(prefix, isAscendingOrder);

            assertCommandSuccess(sortCommand, model, expectedMessage, expectedModel);
        } catch (CommandException e) {
            fail();
        }

    }

    @Test
    public void execute_sortByStatusInAscendingOrder_success() {
        Prefix prefix = PREFIX_STATUS;
        boolean isAscendingOrder = true;
        String order = "ascending order";
        try {
            SortCommand sortCommand = new SortCommand(prefix, isAscendingOrder);
            String expectedMessage = String.format(SortCommand.MESSAGE_SUCCESS, sortCommand.getCriteria(), order);

            Model expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
            expectedModel.sortPersons(prefix, isAscendingOrder);

            assertCommandSuccess(sortCommand, model, expectedMessage, expectedModel);
        } catch (CommandException e) {
            fail();
        }

    }
    @Test
    public void execute_sortByStatusInDescendingOrder_success() {
        Prefix prefix = PREFIX_STATUS;
        boolean isAscendingOrder = false;
        String order = "descending order";
        try {
            SortCommand sortCommand = new SortCommand(prefix, isAscendingOrder);
            String expectedMessage = String.format(SortCommand.MESSAGE_SUCCESS, sortCommand.getCriteria(), order);

            Model expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
            expectedModel.sortPersons(prefix, isAscendingOrder);

            assertCommandSuccess(sortCommand, model, expectedMessage, expectedModel);
        } catch (CommandException e) {
            fail();
        }

    }
    @Test
    public void execute_sortByAddedTimeInAscendingOrder_success() {
        Prefix prefix = PREFIX_ADDED_TIME;
        boolean isAscendingOrder = true;
        String order = "ascending order";
        try {
            SortCommand sortCommand = new SortCommand(prefix, isAscendingOrder);
            String expectedMessage = String.format(SortCommand.MESSAGE_SUCCESS, sortCommand.getCriteria(), order);

            Model expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
            expectedModel.sortPersons(prefix, isAscendingOrder);

            assertCommandSuccess(sortCommand, model, expectedMessage, expectedModel);
        } catch (CommandException e) {
            fail();
        }

    }
    @Test
    public void execute_sortByAddedTimeInDescendingOrder_success() {
        Prefix prefix = PREFIX_ADDED_TIME;
        boolean isAscendingOrder = false;
        String order = "descending order";
        try {
            SortCommand sortCommand = new SortCommand(prefix, isAscendingOrder);
            String expectedMessage = String.format(SortCommand.MESSAGE_SUCCESS, sortCommand.getCriteria(), order);

            Model expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
            expectedModel.sortPersons(prefix, isAscendingOrder);

            assertCommandSuccess(sortCommand, model, expectedMessage, expectedModel);
        } catch (CommandException e) {
            fail();
        }

    }
    @Test
    public void execute_sortByRatingInAscendingOrder_success() {
        Prefix prefix = PREFIX_RATING;
        boolean isAscendingOrder = true;
        String order = "ascending order";
        try {
            SortCommand sortCommand = new SortCommand(prefix, isAscendingOrder);
            String expectedMessage = String.format(SortCommand.MESSAGE_SUCCESS, sortCommand.getCriteria(), order);

            Model expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
            expectedModel.sortPersons(prefix, isAscendingOrder);

            assertCommandSuccess(sortCommand, model, expectedMessage, expectedModel);
        } catch (CommandException e) {
            fail();
        }
    }
    @Test
    public void execute_sortByRatingInDescendingOrder_success() {
        Prefix prefix = PREFIX_RATING;
        boolean isAscendingOrder = false;
        String order = "descending order";
        try {
            SortCommand sortCommand = new SortCommand(prefix, isAscendingOrder);
            String expectedMessage = String.format(SortCommand.MESSAGE_SUCCESS, sortCommand.getCriteria(), order);

            Model expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
            expectedModel.sortPersons(prefix, isAscendingOrder);

            assertCommandSuccess(sortCommand, model, expectedMessage, expectedModel);
        } catch (CommandException e) {
            fail();
        }

    }
    @Test
    public void execute_sortByUnknownCriteria_throwCommandException() {
        // Undefined prefix
        Prefix prefix = new Prefix("z/ d/");
        try {
            SortCommand sortCommand = new SortCommand(prefix, true);
            fail();
        } catch (CommandException e) {
            String expectedExceptionMessage = String.format(
                    MESSAGE_INVALID_CRITERIA_FORMAT, "sorting", SortCommand.MESSAGE_USAGE);
            assertEquals(expectedExceptionMessage, e.getMessage());
        }
    }
    @Test
    public void equals() {
        try {
            boolean isAscendingOrder = true;
            final SortCommand sortByNameCommand = new SortCommand(PREFIX_NAME, isAscendingOrder);

            // same values -> returns true
            Prefix prefixName = new Prefix(PREFIX_NAME.getPrefix());
            final SortCommand commandWithSameValues = new SortCommand(prefixName, isAscendingOrder);
            assertTrue(sortByNameCommand.equals(commandWithSameValues));
            // same object -> returns true
            assertTrue(sortByNameCommand.equals(sortByNameCommand));
            // null -> returns false
            assertFalse(sortByNameCommand.equals(null));
            // different types -> returns false
            assertFalse(sortByNameCommand.equals(new ClearCommand()));
            // different sorting criteria -> returns false
            assertFalse(sortByNameCommand.equals(new SortCommand(PREFIX_STATUS, isAscendingOrder)));
            // different ascending order -> returns false
            assertFalse(sortByNameCommand.equals((new SortCommand(PREFIX_NAME, !isAscendingOrder))));
        } catch (CommandException e) {
            fail();
        }
    }
    @Test
    public void toStringMethod() {
        try {
            Prefix prefix = new Prefix("n/");
            boolean isAscendingOrder = true;
            SortCommand sortCommand = new SortCommand(prefix, isAscendingOrder);
            String expected = SortCommand.class.getCanonicalName() + "{prefix=" + prefix + ", isAscendingOrder="
                    + isAscendingOrder + "}";
            assertEquals(expected, sortCommand.toString());
        } catch (CommandException e) {
            fail();
        }
    }
}
