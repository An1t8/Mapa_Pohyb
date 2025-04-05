package commands;

import main.GameConsole;

import java.io.Serializable;

/**
 * Command that handles loading the game state from a file.
 * Implements the Command pattern to allow deserialization of saved game state.
 */
public class LoadCommand extends Command implements Serializable {

    private GameConsole gameConsole;

    /**
     * Constructs a LoadCommand with a reference to the GameConsole.
     * @param gameConsole The main game controller handling load logic.
     */
    public LoadCommand(GameConsole gameConsole) {
        this.gameConsole = gameConsole;
    }


    /**
     * Executes the load command by loading the saved game state from a predefined file path in the /res directory.
     * @return A message indicating success or failure of the load operation.
     */
    @Override
    public String execute() {

        String fileName = "res/game.txt";
        System.out.println(" Loading game from: " + fileName);
        if (gameConsole.loadGame(fileName)) {
            return "game loaded successfully";
        } else {
            return "Error while loading the game";
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
