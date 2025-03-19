import java.util.List;

public class PlanetGateKeeper {

    private String name;
    private List<Question> questions;
    private boolean crystalTaken = false;

    public PlanetGateKeeper(String name,  List<Question> questions) {
        this.name = name;
        this.questions = questions;
    }


    public String getName() {
        return name;
    }


    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }


    public boolean checkAnswer(Question question, String answer) {
        return question.isCorrect(answer);
    }

    public boolean canTakeCrystal() {
        return !crystalTaken;
    }

    public Crystal allowCrystalTake() {
        if (!crystalTaken) {
            crystalTaken = true;
            return new Crystal(name + " Crystal");
        }
        return null;
    }



}
