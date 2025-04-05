package commands;

import main.GameConsole;

import java.io.Serializable;

public class LoadCommand extends Command implements Serializable {

    private GameConsole gameConsole;
    private static final String DEFAULT_FILENAME = "res/game.txt";

    public LoadCommand(GameConsole gameConsole) {
        this.gameConsole = gameConsole;
    }


    @Override
    public String execute() {
        System.out.println(" Loading game from: " + DEFAULT_FILENAME);
        if (gameConsole.loadGame(DEFAULT_FILENAME)) {
            return "game loaded successfully";
        } else {
            return "Error while loading the game";
        }
    }



    @Override
    public boolean exit() {
        return false;
    }
}
