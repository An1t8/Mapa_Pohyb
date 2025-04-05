package game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The game.Location class represents the player's current location in the universe.
 * It allows movement between connected planets.
 */
public class Location implements Serializable {
    private Planet currentPlanet;

    private List<String> takenCrystals = new ArrayList<>();


    /**
     * Constructs a game.Location with the specified starting planet
     * @param startPlanet The planet where the player starts
     * @throws IllegalArgumentException if the start planet is null
     */
    public Location(Planet startPlanet) {
        if (startPlanet == null) {
            throw new IllegalArgumentException("Start planet cannot be null");
        }
        this.currentPlanet = startPlanet;
    }



    /**
     * Moves the player to the specified destination planet if it exists
     * @param destination name of the planet to move to
     * @return {@code true} if the movement was successful, {@code false} otherwise
     */
    public boolean move(String destination) {
        if (destination == null || destination.isEmpty()) {
            return false;
        }

        String formattedDestination = destination.toLowerCase();
        if (formattedDestination.equals(currentPlanet.name.toLowerCase())) {

            return true;
        }

        if (currentPlanet.connections.containsKey(formattedDestination)) {
            currentPlanet = currentPlanet.connections.get(formattedDestination);
            return true;

        } else {

            return false;
        }
    }


    public List<String> getTakenCrystals() {
        return takenCrystals;
    }



    public String getCurrentLocation() {
        return currentPlanet.name;
    }



    public Planet getCurrentPlanet() {
        return currentPlanet;
    }


    public void setCurrentLocation(Planet planet) {
        this.currentPlanet = planet;
    }
}

