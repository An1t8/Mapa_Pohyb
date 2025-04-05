package commands;

import main.GameConsole;

import java.io.Serializable;

/**
 * Command that handles saving the game state to a file.
 * Implements the Command pattern to allow serialization of game state.
 */
public class SaveCommand extends Command implements Serializable {


    private GameConsole gameConsole;


    /**
     * Constructs a SaveCommand with a reference to the GameConsole.
     * @param gameConsole The main game controller handling save logic.
     */
    public SaveCommand(GameConsole gameConsole) {
        this.gameConsole = gameConsole;
    }

    /**
     * Executes the save command by saving the current game state
     * to a predefined file path in the /res directory.
     * @return A message indicating success or failure of the save operation.
     */
    @Override
    public String execute() {

        String fileName = "res/game.txt";
        System.out.println(" Saving game to: " + fileName);
        if (gameConsole.saveGame(fileName)) {
            return "Game state saved successfully.\n You can now use 'leave' to exit the game. ";
        } else {
            return "Error saving game state.";
        }

    }

    /**
     * Determines whether the command causes the game to exit.
     * @return False, since this command does not exit the game.
     */
    @Override
    public boolean exit() {
        return false;
    }
}
