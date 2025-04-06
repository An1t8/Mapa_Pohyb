package game;

import java.io.*;
import java.util.HashMap;

/**
 * The game.Universe class manages the map of planets in the game. It loads planet data from a file and connects planets based on the data.
 * Each planet is connected to other planets, forming a network of planets.
 */
public class Universe implements Serializable {

    private static final long serialVersionUID = 1L; // Add this line

    public HashMap<String, Planet> planets;

    HashMap<String, Boolean> takenCrystals;

    public Universe() {
        this.planets = new HashMap<>();
        this.takenCrystals = new HashMap<>();

    }

    /**
     * Loads planet data from a file and sets up the planets and their connections.
     * @param filename The name of the file to read planet data from.
     */
    public void loadMap(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 0) {
                    planets.putIfAbsent(parts[0], new Planet(parts[0]));
                    Planet planet = planets.get(parts[0]);

                    for (int i = 1; i < parts.length; i++) {
                        if (!parts[i].isEmpty()) {
                            planets.putIfAbsent(parts[i], new Planet(parts[i]));
                            Planet connectedPlanet = planets.get(parts[i]);
                            planet.connect(connectedPlanet.name, connectedPlanet);
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("error: " + e);
        }

    }

    /**
     * Retrieves a planet by its name.
     * @param name The name of the planet to retrieve.
     * @return The game.Planet object if found, otherwise prints a message and returns null.
     */
    public Planet getPlanet(String name) {
        Planet planet = planets.get(name);
        if (planet == null) {
            System.out.println("Planet " + name + " not found");
        }
        return planet;
    }

    /**
     * Gets the map of taken crystals.
     * @return a map where keys are crystal names and values indicate whether they are taken
     */
    public HashMap<String, Boolean> getTakenCrystals() {
        return takenCrystals;
    }

    /**
     * Marks a crystal as taken in the universe.
     * This prevents the same crystal from being collected again.
     * @param crystalName the name of the crystal
     */
    public void crystalTaken(String crystalName) {
        takenCrystals.put(crystalName, true);
    }

    /**
     * Checks whether a crystal has already been taken.
     * @param crystalName the name of the crystal
     * @return {@code true} if the crystal has been taken; {@code false} otherwise
     */
    public boolean isCrystalTaken(String crystalName) {
        return takenCrystals.getOrDefault(crystalName, false);
    }



    public HashMap<String, Planet> getPlanets() {
        return planets;
    }
}
