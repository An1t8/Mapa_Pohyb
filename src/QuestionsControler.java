import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

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
                        questions.add(new Question(questionText, correctAnswer, new ArrayList<>()));
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

    public PlanetGateKeeper getPlanetKeeper(String planetName) {
        return planetKeepers.get(planetName);
    }

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

    public GalacticSailor getGalacticSailor() {
        return galacticSailor;
    }

    public void setGalacticSailor(GalacticSailor galacticSailor) {
        this.galacticSailor = galacticSailor;
    }
}
