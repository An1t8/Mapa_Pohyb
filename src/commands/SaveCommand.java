package commands;

import main.GameConsole;

import java.io.Serializable;

public class SaveCommand extends Command implements Serializable {


    private GameConsole gameConsole;
    private String filename;


    public SaveCommand(GameConsole gameConsole) {
        this.gameConsole = gameConsole;
    }

    @Override
    public String execute() {
        if (gameConsole.saveGame(filename)) {
            return "Game was successfully saved into the file " + (filename.isEmpty() ? "game.txt" : filename);
        } else {
            return "Error while saving the game.";
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
