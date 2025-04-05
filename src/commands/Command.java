package commands;

import java.io.Serializable;

/**
 * The commands.Command class is an abstract class that represents a game command.
 */

public abstract class Command {

    protected String command;

    /**
     * Sets the command string associated with this command.
     * @param command The command string to be set.
     */
    public void setCommand(String command) {
        this.command = command;
    }

    /**
     * Executes the command and performs the associated action.
     */
    public abstract String execute();

    /**
     * Determines whether this command should terminate the game.
     */
    public abstract boolean exit();

}
