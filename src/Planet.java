import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Map<Question, List<String>> getQuestions() {
        return questions;
    }

    public void addQuestion(Question question, List<String> hints) {
        this.questions.put(question, hints);
    }

}

