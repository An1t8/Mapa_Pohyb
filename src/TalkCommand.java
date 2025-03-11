import java.util.Scanner;

public class TalkCommand extends Command {

    private GalacticSailor player;
    private PlanetGateKeeper pgk;


    Scanner sc = new Scanner(System.in);

    public TalkCommand(GalacticSailor player, PlanetGateKeeper pgk) {
        this.player = player;
        this.pgk = pgk;
    }

    @Override
    public String execute() {
        PlanetGateKeeper pgk = player.getCurrentPGK();

        if (pgk == null) {
            return "There's no one to talk to on this planet.";
        }

        QuestionSession session = player.getCurrentSession();
        if (session == null) {
            session = new QuestionSession(pgk);
            player.setCurrentSession(session);
            session.startSession();
        }

        if (session.isSessionCompleted()) {
            return "You've already answered all questions correctly! You can use the 'take' command to collect a crystal.";
        }

        Question currentQuestion = session.getCurrentQuestion();
        if (currentQuestion == null) {
            return "No more questions available.";
        }

        System.out.println("Question: " + currentQuestion.getQuestionText());
        System.out.print("Your answer: ");
        String answer = sc.nextLine();

        if (session.submitAnswer(answer)) {
            if (session.isSessionCompleted()) {
                return "Correct! You've answered all questions correctly. You can now take a crystal using the 'take' command.";
            }
            return "Correct! Next question will be available when you use 'talk' command again.";
        } else {
            return "Incorrect answer. Try again or use the 'prompter' command for hints.";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
