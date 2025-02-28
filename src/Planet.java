import java.util.HashMap;

public class Planet {

    public String name;


     HashMap<String, Planet> connections;

    public Planet(String name) {
        this.name = name;
        this.connections = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void connect(String name, Planet planet) {
        if (planet != null) {
            connections.put(name, planet);
            planet.connections.put(this.name, this); //oboustranne spojeni
        }
    }

    public Planet getConnection(String direction) {
        return connections.get(direction);
    }

    public boolean canTravel(String direction) {
        return connections.containsKey(direction);
    }

}

