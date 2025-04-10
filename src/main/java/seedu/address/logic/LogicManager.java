package seedu.address.logic;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Path;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.DeleteCommand;
import seedu.address.logic.commands.UpdateCommand;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.AddressBookParser;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.applicant.Applicant;
import seedu.address.storage.Storage;

/**
 * The main LogicManager of the app.
 */
public class LogicManager implements Logic {
    public static final String FILE_OPS_ERROR_FORMAT = "Could not save data due to the following error: %s";

    public static final String FILE_OPS_PERMISSION_ERROR_FORMAT =
            "Could not save data to file %s due to insufficient permissions to write to the file or the folder.";

    public static final String MESSAGE_EXPORT_FAILURE = "Failed to export applicant list.";

    private final Logger logger = LogsCenter.getLogger(LogicManager.class);

    private final Model model;
    private final Storage storage;
    private final AddressBookParser addressBookParser;
    private Command pendingCommand = null;

    /**
     * Constructs a {@code LogicManager} with the given {@code Model} and {@code Storage}.
     */
    public LogicManager(Model model, Storage storage) {
        this.model = model;
        this.storage = storage;
        addressBookParser = new AddressBookParser();
    }

    @Override
    public CommandResult execute(String commandText) throws CommandException, ParseException {
        logger.info("----------------[USER COMMAND][" + commandText + "]");
        CommandResult commandResult;

        if (pendingCommand != null) {
            if (commandText.equalsIgnoreCase("yes")) {
                if (pendingCommand instanceof DeleteCommand deleteCommand) {
                    deleteCommand.setForceDelete(true);
                    commandResult = deleteCommand.execute(model);
                } else {
                    UpdateCommand updateCommand = (UpdateCommand) pendingCommand;
                    updateCommand.setForceUpdate(true);
                    commandResult = updateCommand.execute(model);
                }
            } else {
                String cancelMessage = pendingCommand instanceof DeleteCommand
                        ? "Deletion cancelled. Type 'list' to see the list of applicants."
                        : "Update cancelled. Type 'list' to see the list of applicants.";
                pendingCommand = null;
                return new CommandResult(cancelMessage);
            }
            pendingCommand = null;
        } else {
            Command command = addressBookParser.parseCommand(commandText);
            commandResult = command.execute(model);

            if (commandResult.isConfirmation()) {
                pendingCommand = command;
            }
        }

        saveAddressBook();

        return commandResult;
    }

    /**
     * Saves the current address book data to storage.
     *
     * @throws CommandException If an error occurs during saving
     */
    public void saveAddressBook() throws CommandException {
        try {
            storage.saveAddressBook(model.getAddressBook());
        } catch (AccessDeniedException e) {
            throw new CommandException(String.format(FILE_OPS_PERMISSION_ERROR_FORMAT, e.getMessage()), e);
        } catch (IOException ioe) {
            throw new CommandException(String.format(FILE_OPS_ERROR_FORMAT, ioe.getMessage()), ioe);
        }
    }

    @Override
    public Command parseCommand(String commandText) throws ParseException {
        return addressBookParser.parseCommand(commandText);
    }

    @Override
    public ReadOnlyAddressBook getAddressBook() {
        return model.getAddressBook();
    }

    @Override
    public ObservableList<Applicant> getFilteredPersonList() {
        return model.getFilteredPersonList();
    }

    @Override
    public Path getAddressBookFilePath() {
        return model.getAddressBookFilePath();
    }

    @Override
    public GuiSettings getGuiSettings() {
        return model.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        model.setGuiSettings(guiSettings);
    }
}
