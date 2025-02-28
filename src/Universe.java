import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.io.FileReader;
import java.io.FileNotFoundException;


class Universe {
    HashMap<String, Planet> planets = new HashMap<>();


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

    Planet getPlanet(String name) {
        Planet planet = planets.get(name);
        if (planet == null) {
            System.out.println("Planet " + name + " not found");
        }
        return planet;
    }
    }
