import java.util.List;

/**
 * Represents a gatekeeper on a planet who holds a set of questions.
 * The player must answer these questions correctly to obtain a crystal.
 */
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


    /**
     * Checks if the given answer to a question is correct.
     * @param question The question being answered.
     * @param answer   The player's answer.
     * @return {@code true} if the answer is correct, {@code false} otherwise.
     */
    public boolean checkAnswer(Question question, String answer) {
        return question.isCorrect(answer);
    }

    /**
     * Determines if the player is allowed to take the crystal.
     * @return {@code true} if the crystal has not yet been taken, {@code false} otherwise.
     */
    public boolean canTakeCrystal() {
        return !crystalTaken;
    }


    /**
     * Allows the player to take a crystal if it hasn't been taken already.
     * @return A new Crystal if available, or {@code null} if the crystal has already been taken.
     */
    public Crystal allowCrystalTake() {
        if (!crystalTaken) {
            crystalTaken = true;
            return new Crystal(name + " Crystal");
        }
        return null;
    }



}
