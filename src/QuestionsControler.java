import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * The QuestionsControler class manages planet gatekeepers and their questions.
 * It loads questions from a file and assigns them to the corresponding planets.
 */
public class QuestionsControler {

    private GalacticSailor galacticSailor;
    private Map<String, PlanetGateKeeper> planetKeepers;
    private CrystalBag crystalBag;

    public QuestionsControler(GalacticSailor galacticSailor, CrystalBag crystalBag) {
        this.galacticSailor = galacticSailor;
        this.crystalBag = crystalBag;
        this.planetKeepers = new HashMap<>();
        loadQuestionsFromFile("questions.txt");
    }

    /**
     * Loads questions from a file and assigns them to planet gatekeepers.
     * @param filename The name of the file containing questions.
     * written with the help of chatgpt
     */
    private void loadQuestionsFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            String currentPlanetName = null;
            List<Question> questions = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                if (line.startsWith("//")) {
                    // Skip comments
                    continue;
                }

                if (line.isEmpty()) continue; // Skip empty lines

                if (line.startsWith("Welcome to")) {
                    if (currentPlanetName != null && !questions.isEmpty()) {
                        PlanetGateKeeper keeper = new PlanetGateKeeper(currentPlanetName, new ArrayList<>(questions));
                        planetKeepers.put(currentPlanetName, keeper);
                        questions.clear();
                    }
                    String[] parts = line.split(" ");
                    if (parts.length >= 3) {
                        currentPlanetName = parts[2].replace(",", "").replace("!", "");
                    }
                } else if (line.contains("|")) {
                    String[] parts = line.split("\\|");
                    if (parts.length == 2) {
                        String questionText = parts[0].trim();
                        String correctAnswer = parts[1].trim();
                        questions.add(new Question(questionText, correctAnswer//, new ArrayList<>()
                        ));
                    }
                }
            }
            if (currentPlanetName != null && !questions.isEmpty()) {
                PlanetGateKeeper keeper = new PlanetGateKeeper(currentPlanetName, new ArrayList<>(questions));
                planetKeepers.put(currentPlanetName, keeper);
            }
        } catch (IOException e) {
            System.out.println("Error reading questions: " + e.getMessage());
            e.printStackTrace();
        }
    }


    /**
     * Retrieves the PlanetGateKeeper for a given planet.
     * @param planetName The name of the planet.
     * @return The PlanetGateKeeper if found, otherwise null.
     */
    public PlanetGateKeeper getPlanetKeeper(String planetName) {
        return planetKeepers.get(planetName);
    }


    /**
     * Allows the GalacticSailor to visit a planet and interact with its gatekeeper.
     * @param planetName The name of the planet to visit.
     */
    public void visitPlanet(String planetName) {
        PlanetGateKeeper selectedPlanet = planetKeepers.get(planetName);

        if (selectedPlanet == null) {
            System.out.println("Planet not found or no questions available for this planet.");
            return;
        }

        galacticSailor.setCurrentPGK(selectedPlanet);

        System.out.println("To answer questions, use the 'talk' command.");
        System.out.println("If you need help with an answer, try using the 'prompter' command.");
    }

    /**
     * Gets the GalacticSailor associated with this controller.
     * @return The GalacticSailor instance.
     */
    public GalacticSailor getGalacticSailor() {
        return galacticSailor;
    }


    public void setGalacticSailor(GalacticSailor galacticSailor) {
        this.galacticSailor = galacticSailor;
    }
}
