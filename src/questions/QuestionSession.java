package questions;

import commands.Prompter;
import game.GalacticSailor;
import game.PlanetGateKeeper;

import java.util.List;


/**
 * Manages a session where the player answers questions given by a game.PlanetGateKeeper.
 */
public class QuestionSession {

    private GalacticSailor galacticSailor;
    private PlanetGateKeeper pgk;
    private int currentQuestionIndex = 0;
    private boolean sessionCompleted = false;
    private List<Question> questions;
    private Prompter prompter;


    /**
     * Constructs a questions.QuestionSession for a given game.PlanetGateKeeper.
     * @param pgk The game.PlanetGateKeeper managing the questions.
     */
    public QuestionSession(PlanetGateKeeper pgk) {
        this.questions = pgk.getQuestions();
        this.pgk = pgk;
        this.currentQuestionIndex = 0;
        this.prompter = new Prompter(galacticSailor);
    }

    /**
     * Starts or resets the session.
     */
    public void startSession() {
        currentQuestionIndex = 0;
        sessionCompleted = false;
    }


    /**
     * Retrieves the current question the player needs to answer.
     * @return The current questions.Question, or null if no more questions are available.
     */
    public Question getCurrentQuestion() {
        if (currentQuestionIndex < pgk.getQuestions().size()) {
            return pgk.getQuestions().get(currentQuestionIndex);
        }
        return null;
    }


    /**
     * Submits an answer for the current question and advances if correct.
     * @param answer The player's answer.
     * @return true if the answer is correct, false otherwise.
     */

    public boolean submitAnswer(String answer) {
        Question currentQuestion = getCurrentQuestion();
        if (currentQuestion != null) {
            if (pgk.checkAnswer(currentQuestion, answer)) {
                currentQuestionIndex++;
                if (currentQuestionIndex >= pgk.getQuestions().size()) {
                    sessionCompleted = true;
                }
                return true;
            }
        }

        return false;

    }


    /**
     * Checks whether the question session has been completed.
     * @return true if all questions have been answered, false otherwise.
     */
    public boolean isSessionCompleted() {
        return sessionCompleted || (pgk.getQuestions() != null && currentQuestionIndex >= pgk.getQuestions().size());
    }


}
