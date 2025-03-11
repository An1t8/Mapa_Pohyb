import java.util.ArrayList;

public class QuestionSession {

    private GalacticSailor galacticSailor;
    private PlanetGateKeeper gatekeeper;
    private int currentQuestionIndex = 0;
    private boolean sessionCompleted = false;


    public QuestionSession(GalacticSailor galacticSailor, PlanetGateKeeper gatekeeper) {
        this.galacticSailor = galacticSailor;
        this.gatekeeper = gatekeeper;
    }

    public void startSession() {
        currentQuestionIndex = 0;
        sessionCompleted = false;
    }

    public Question getCurrentQuestion() {
       return null;
    }

    public boolean submitAnswer(String answer) {
        return true;
    }

    public boolean isSessionCompleted() {
        return true;
    }




}
