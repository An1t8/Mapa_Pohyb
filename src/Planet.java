import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a planet in the universe. Each planet can have connections to other planets,
 */
public class Planet {

    public String name;


     HashMap<String, Planet> connections;

     private Map<Question, List<String>> questions = new HashMap<>();

    public Planet(String name) {
        this.name = name;
        this.connections = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    /**
     * Establishes a two-way connection between this planet and another planet.
     * @param name   The name of the connected planet.
     * @param planet The planet to connect to.
     */
    public void connect(String name, Planet planet) {
        if (planet != null) {
            connections.put(name, planet);
            planet.connections.put(this.name, this); //oboustranne spojeni
        }
    }

    public Planet getConnection(String direction) {
        return connections.get(direction);
    }


    public Map<Question, List<String>> getQuestions() {
        return questions;
    }


}

