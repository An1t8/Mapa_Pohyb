import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.io.FileReader;
import java.io.FileNotFoundException;

/**
 * The Universe class manages the map of planets in the game. It loads planet data from a file and connects planets based on the data.
 * Each planet is connected to other planets, forming a network of planets.
 */
class Universe {
    HashMap<String, Planet> planets = new HashMap<>();



    /**
     * Loads planet data from a file and sets up the planets and their connections.
     * @param filename The name of the file to read planet data from.
     */
    void loadMap(String filename) {
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
     * @return The Planet object if found, otherwise prints a message and returns null.
     */
    Planet getPlanet(String name) {
        Planet planet = planets.get(name);
        if (planet == null) {
            System.out.println("Planet " + name + " not found");
        }
        return planet;
    }
}
