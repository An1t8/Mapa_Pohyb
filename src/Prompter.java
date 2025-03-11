import java.util.List;

public class Prompter extends Command {

    private QuestionSession crSession;

    public Prompter(QuestionSession Session) {
        this.crSession = Session;

    }


    @Override
    public String execute() {
        if (crSession != null && !crSession.isSessionCompleted()) {
            Question currentQuestion = crSession.getCurrentQuestion();

            if (currentQuestion != null) {
                List<String> hints = currentQuestion.getHints();


                if (!hints.isEmpty()) {
                    StringBuilder hintsMessage = new StringBuilder("Hints for the question:\n");
                    for (int i = 0; i < hints.size(); i++) {
                        hintsMessage.append((i + 1)).append(". ").append(hints.get(i)).append("\n");
                    }
                    return hintsMessage.toString();
                }
            }
        }
        return "No hints available";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
