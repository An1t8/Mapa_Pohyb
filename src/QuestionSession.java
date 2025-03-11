import java.util.ArrayList;
import java.util.List;

public class QuestionSession {

    private GalacticSailor galacticSailor;
    private PlanetGateKeeper pgk;
    private int currentQuestionIndex = 0;
    private boolean sessionCompleted = false;
    private List<Question> questions;



    public QuestionSession(PlanetGateKeeper pgk) {
        this.questions = pgk.getQuestions();
        this.pgk = pgk;
        this.currentQuestionIndex = 0;
    }

    public void startSession() {
        currentQuestionIndex = 0;
        sessionCompleted = false;
    }

    public Question getCurrentQuestion() {
        if (currentQuestionIndex < pgk.getQuestions().size()) {
            return pgk.getQuestions().get(currentQuestionIndex);
        }
        return null;
    }

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

    public boolean isSessionCompleted() {
        return sessionCompleted || (pgk.getQuestions() != null && currentQuestionIndex >= pgk.getQuestions().size());
    }


}
