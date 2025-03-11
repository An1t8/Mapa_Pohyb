import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

public class GameConsole {
    private boolean exit = false;
    private HashMap<String, Command> commands = new HashMap<>();
    public static String commandLogFile = "commands.txt";

    private Scanner scanner = new Scanner(System.in);
    private CrystalBag crystalBag = new CrystalBag();
    private BaseStation baseStation = new BaseStation();
    private Universe universe = new Universe();
    private Location playerLocation;
    private Astrokoala astroKoala;
    private BigBang bigBang = new BigBang();
    private Comet comet;
    private GalacticSailor galacticSailor;
    private PlanetGateKeeper pgk;



    public void initialize() {
        universe.loadMap("map.csv");

        Planet startPlanet = universe.getPlanet("Station");
        if (startPlanet == null) {
            System.out.println("Station not found in the universe.");
            return;
        }
        playerLocation = new Location(startPlanet);
        astroKoala = new Astrokoala(baseStation);
        comet = new Comet();

        commands = new HashMap<>();
        commands.put("fly", new FlyCommand(playerLocation));
        commands.put("talk", new TalkCommand(galacticSailor, pgk));
        commands.put("take", new TakeCrystal(crystalBag, pgk));
        commands.put("position", new PositionCrystal(crystalBag, baseStation));
        commands.put("help", new Help());
        commands.put("leave", new Exit());
        commands.put("hint", new HintCommand(astroKoala));
        commands.put("check", new CheckCrystals(astroKoala));
        commands.put("rules", new RulesCommand(astroKoala));
        commands.put("bigbang", new BigBang());
        commands.put("comet", comet);
    }

    private void showIntro() {
        System.out.println("\nWelcome to the Space Adventure Game! 🚀");
        System.out.println("You are currently on " + playerLocation.getCurrentLocation());
        System.out.println("\n📍 **Available Planets:**");
        System.out.println("""
                - Station  → The main station where your space journey begins.
                - Colverde → A green planet full of vegetation and oxygen.
                - Luminara → A glowing planet filled with light sources.
                - Rosetta  → A planet with pink rocks and a strange atmosphere.
                - Crystalia → A planet covered in icy crystals.
                - Lavatron  → A hot planet with active volcanoes.
                - Aquarix  → A water world with endless oceans.
                - Solaria  → A sun-scorched desert planet.
                - Glacius  → An icy planet with extremely low temperatures.
                - Verdania → A planet covered in dense forests and exotic creatures.
                - Mysterra → A mysterious planet shrouded in mist and secrets.
                """);
        System.out.println("\n⌨️ **Available Commands:**");
        System.out.println("""
                - fly [planet]      → Travel to a new planet.
                - talk              → Interact with someone on the planet.
                - take              → Collect a crystal from the environment.
                - position          → Place a collected crystal at the base station.
                - hint              -> Astrokoala gives you a random hint of the game.
                - check             -> Astrokoala checks if the crystals are placed correctly.
                - rules             -> Astrokoala reminds you of the game rules.
                - help              → Show available commands.
                - leave             → Exit the game.
                - bigbang           → Trigger the Big Bang event when two comets are ready.
                - comet             → shows all infos about the comets.
                """);
        System.out.println("Type a command to begin your adventure!\n");
    }

    private void executeCommand() {
        System.out.print(">> ");
        String input = scanner.nextLine().trim().toLowerCase();
        logCommand(input);

        String[] parts = input.split(" ", 2);
        String commandKey = parts[0];
        String argument = parts.length > 1 ? parts[1] : "";

        if (commands.containsKey(commandKey)) {
            Command command = commands.get(commandKey);
            command.setCommand(argument);
            System.out.println(" " + command.execute());
            exit = command.exit();
        } else {
            System.out.println(">> Invalid command");
        }
    }

    public void start() {
        initialize();
        showIntro();
        try {
            resetCommandLog();
            do {
                executeCommand();
            } while (!exit);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void logCommand(String command) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(commandLogFile, true))) {
            bw.write(command);
            bw.newLine();
        } catch (Exception e) {
            System.out.println("Error logging command: " + e.getMessage());
        }
    }

    private void resetCommandLog() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(commandLogFile, false))) {
        } catch (Exception e) {
            System.out.println("Error resetting command log: " + e.getMessage());
        }
    }
}