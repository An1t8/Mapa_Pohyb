package commands;

import game.*;
import questions.QuestionsControler;

/**
 * The commands.FlyCommand class extends command that allows the player to fly to different planets in the universe.
 * The command requires a destination planet and moves the player to that location, interacting with the environment.
 */

public class FlyCommand extends Command {


    private Location playerLocation;
    private String destination;
    private Universe universe;
    private QuestionsControler questionsControler;
    private GalacticSailor player;
    private PlanetGateKeeper pgk;
    private BaseStation station;

    public FlyCommand(Location playerLocation, QuestionsControler questionsControler, Universe universe, PlanetGateKeeper pgk, BaseStation station) {
        this.playerLocation = playerLocation;
        this.questionsControler = questionsControler;
        this.universe = universe;
        this.pgk = pgk;
        this.station = station;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public QuestionsControler getQuestionsControler() {
        return questionsControler;
    }



    /**
     * Executes the fly command, moving the player to the specified planet.
     * If the player is already at the destination, no movement occurs.
     * If successful, the player's interaction with the planet's gatekeeper is triggered.
     * @return A message indicating the result of the flight
     */
    @Override
    public String execute() {
        if (destination == null || destination.isEmpty()) {
            return "Please specify a destination planet. 'fly [planet]'";
        }

        String destinationName = destination.trim();



        if (destination.equalsIgnoreCase(playerLocation.getCurrentLocation())) {
            System.out.println("You are already on a " + playerLocation.getCurrentLocation() + ".");
        } else {

            boolean success = playerLocation.move(destinationName);

            if (success) {

                System.out.println("\n\uD83D\uDEF8 Flying to " + destinationName + "... ");
                String currentPlanet = playerLocation.getCurrentLocation();

                if ("Station".equalsIgnoreCase(currentPlanet)) {
                    station.text();
                } else {
                    System.out.println("\n\uD83D\uDC7D : Welcome to " + currentPlanet + "! \nIf you wish to take one of our crystals, you must answer all my questions correctly.");
                }

                PlanetGateKeeper pgk = questionsControler.getPlanetKeeper(currentPlanet);
                if (pgk != null) {
                    questionsControler.visitPlanet(currentPlanet);
                } else {
                    System.out.println("No PGK available on " + currentPlanet + ".");
                }

            } else {
                return "this planet doesn't exist in this universe";
            }
        }
        return "";
    }

    /*@Override
    public String execute() {
        if (destination == null || destination.isEmpty()) {
            return "Please specify a destination planet. 'fly [planet]'";
        }

        String destinationName = destination.trim();

        String currentPlanetName = playerLocation.getCurrentLocation();

        if (destinationName.equalsIgnoreCase(currentPlanetName)) {
            System.out.println("You are already on " + currentPlanetName + ".");
        } else {
            boolean success = playerLocation.move(destinationName);

            if (success) {
                System.out.println("\n\uD83D\uDEF8 Flying to " + destinationName + "... ");
                currentPlanetName = playerLocation.getCurrentLocation();

                if ("Station".equalsIgnoreCase(currentPlanetName)) {
                    station.text();
                } else {
                    System.out.println("\n\uD83D\uDC7D : Welcome to " + currentPlanetName + "! \nIf you wish to take one of our crystals, you must answer all my questions correctly.");
                }

                game.PlanetGateKeeper pgk = questionsControler.getPlanetKeeper(currentPlanetName);
                if (pgk != null) {
                    questionsControler.visitPlanet(currentPlanetName);
                } else {
                    System.out.println("No PGK available on " + currentPlanetName + ".");
                }
            } else {
                return "This planet doesn't exist in this universe.";
            }
        }
        return "";
    }

     */


    @Override
    public boolean exit() {
        return false;
    }
}
