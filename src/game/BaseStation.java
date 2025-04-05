package game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The game.BaseStation class represents a space station where players can place
 * crystals and interact with game.Astrokoala.
 */
public class BaseStation implements Serializable {

    private ArrayList<Crystal> placedCrystals;
    private Planet planet;

    /**
     * Constructs a new game.BaseStation with an empty list of placed crystals.
     */
    public BaseStation(Planet planet) {
        this.placedCrystals = new ArrayList<>();
        this.planet = planet;
    }

    /**
     * Places a crystal on the base station.
     * @param crystal The crystal to be placed. If the crystal is null, it will not be added.
     */
    public void placeCrystal(Crystal crystal) {
        if (crystal != null) {
            placedCrystals.add(crystal);
        }
    }

    /**
     * Displays a message with instructions on how to use the base station.
     */
    public void text() {
        System.out.println("\nYou are now on Station. Use 'position' to place all crystals from your Crystalbag on the base station. \nYour friend, game.Astrokoala is here, when you think your comets are ready use 'check' and game.Astrokoala will check if you have all the crystals!");
    }

    /**
     * Returns a list of crystals that have been placed on the base station.
     * @return A list of placed crystals.
     */
    public List<Crystal> getPlacedCrystals() {
        return placedCrystals;
    }

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }
}
