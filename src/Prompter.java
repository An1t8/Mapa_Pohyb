import java.util.List;

public class Prompter extends Command {

    private GalacticSailor player;

    public Prompter(GalacticSailor player) {
        this.player = player;
    }

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
        hints.append("1. Think about ").append(questionText.split(" ")[0]).append("...\n");

        hints.append("2. The answer has ").append(correctAnswer.length()).append(" characters.\n");

        hints.append("3. The answer starts with the letter '").append(correctAnswer.charAt(0)).append("'.\n");

        return hints.toString();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
