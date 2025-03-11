//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    public static void main(String[] args) {
        Universe universe = new Universe();
        universe.loadMap("map.csv");
        GameConsole gc = new GameConsole();
        gc.start();

    }
}