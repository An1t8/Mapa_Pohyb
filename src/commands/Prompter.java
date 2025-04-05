package commands;

import game.GalacticSailor;
import game.PlanetGateKeeper;
import questions.Question;
import questions.QuestionSession;

import java.io.Serializable;

/**
 * The commands.Prompter class provides hints to the player about the current question.
 * It extends the commands.Command class, allowing it to be executed as a game command.
 */
public class Prompter extends Command  implements Serializable {

    private GalacticSailor player;

    public Prompter(GalacticSailor player) {
        this.player = player;
    }


    /**
     * @return A string containing hints about the current question.
     */
    public String getHint() {
        return execute();
    }


    /**
     * Executes the prompter command, generating hints for the player's current question.
     * @return A message containing hints, or an appropriate response if no hints are available.
     */
    @Override
    public String execute() {
        PlanetGateKeeper pgk = player.getCurrentPGK();
        if (pgk == null) {
            return "There are no questions to help with on this planet.";
        }


        QuestionSession session = player.getCurrentSession();
        if (session == null || session.isSessionCompleted()) {
            return "No active questions to provide hints for.";
        }

        Question currentQuestion = session.getCurrentQuestion();
        if (currentQuestion == null) {
            return "No questions available at the moment.";
        }

        String questionText = currentQuestion.getQuestionText();
        String correctAnswer = currentQuestion.getCorrectAnswer();

        StringBuilder hints = new StringBuilder("Hints for the current question:\n");
        hints.append("1. The answer has ").append(correctAnswer.length()).append(" characters.\n");
        hints.append("2. The answer starts with the letter '").append(correctAnswer.charAt(0)).append("'.\n");

        return hints.toString();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
