/**
 * The Exit class represents a command that exits the game.
 * When executed, it terminates the game and returns a message to the player.
 */
public class Exit extends Command{

    /**
     * Executes the exit command, terminating the game.
     * @return A message indicating the player has left the game.
     */
    @Override
    public String execute() {
        return "You left the game.";
    }


    /**
     * Indicates whether this command should terminate the game.
     * @return true, since this command ends the game.
     */
    @Override
    public boolean exit() {
        return true;
    }
}
