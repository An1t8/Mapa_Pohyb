package game;

import java.io.*;
import java.util.HashMap;

/**
 * The game.Universe class manages the map of planets in the game. It loads planet data from a file and connects planets based on the data.
 * Each planet is connected to other planets, forming a network of planets.
 */
public class Universe implements Serializable {
    HashMap<String, Planet> planets;

    private HashMap<String, Boolean> takenCrystals;


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
        if (takenCrystals == null) {
            takenCrystals = new HashMap<>();
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

    public HashMap<String, Boolean> getTakenCrystals() {
        return takenCrystals;
    }

    public void markCrystalAsTaken(String crystalName) {
        takenCrystals.put(crystalName, true);
    }

    // Metoda pro kontrolu, jestli byl krystal již vzat
    public boolean isCrystalTaken(String crystalName) {
        return takenCrystals.getOrDefault(crystalName, false);
    }

}
