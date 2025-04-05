package commands;

import main.GameConsole;

import java.io.Serializable;

public class LoadCommand extends Command implements Serializable {

    private GameConsole gameConsole;
    private String filename;

    public LoadCommand(GameConsole gameConsole) {
        this.gameConsole = gameConsole;
    }


    @Override
    public String execute() {
        if (gameConsole.loadGame(filename)) {
            return "game was successfully loaded from the file " + (filename.isEmpty() ? "game.txt" : filename);
        } else {
            return "Error while loading the game";
        }
    }

    @Override
    public void setCommand(String command) {
        this.filename = command.trim();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
