import java.util.ArrayList;

public class PlanetGateKeeper {

    private String planetName;
    private int difficutlyLevel;
    private boolean isFriendly;
    private ArrayList<Question> questions;

    public PlanetGateKeeper(String planetName, int difficutlyLevel, boolean isFriendly, ArrayList<Question> questions) {
        this.planetName = planetName;
        this.difficutlyLevel = difficutlyLevel;
        this.isFriendly = isFriendly;
        this.questions = questions;
    }


    public void greetPlayer(GalacticSailor player){

    }


    public boolean checkAnswer(String answer) {
        return false;
    }

    public String getName() {
        return planetName;
    }

    public boolean isFriendly() {
        return isFriendly;
    }

    public boolean canTakeCrystal() {
        return questions.isEmpty();
    }

    public boolean askQuestion(String answer) {
        return answer.equalsIgnoreCase("correct");
    }


    public Crystal allowCrystalTake() {
        Crystal crystal = new Crystal("");
        return crystal;
    }



}
