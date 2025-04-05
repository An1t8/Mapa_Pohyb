package commands;

import main.GameConsole;

import java.io.Serializable;

public class SaveCommand extends Command implements Serializable {


    private GameConsole gameConsole;
    private static final String DEFAULT_FILENAME = "res/game.txt";


    public SaveCommand(GameConsole gameConsole) {
        this.gameConsole = gameConsole;
    }

    @Override
    public String execute() {
        System.out.println(" Saving game to: " + DEFAULT_FILENAME);
        if (gameConsole.saveGame(DEFAULT_FILENAME)) {
            return "Game state saved successfully.";
        } else {
            return "Error saving game state.";
        }

    }


    @Override
    public boolean exit() {
        return false;
    }
}
