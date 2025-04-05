package main;
import game.Universe;

/**
 * The entry point of the Space Adventure game "The Beginning".
 * This class initializes the game world and starts the game loop.
 */
public class Main {

    /**
     * The main method that launches the game.
     * It initializes the universe, loads the map, and starts the game console.
     */
    public static void main(String[] args) {
        Universe universe = new Universe();
        universe.loadMap("res/map.csv");
        GameConsole gc = new GameConsole();
        gc.start();

    }
}