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

        while (!session.isSessionCompleted()) {
            Question currentQuestion = session.getCurrentQuestion();
            if (currentQuestion == null) {
                return "No more questions available.";
            }

            System.out.println("Question: " + currentQuestion.getQuestionText());

            while (true) {
                System.out.print("Your answer (or type 'prompter' for a hint): ");
                String answer = sc.nextLine().trim().toLowerCase();

                if (answer.equals("prompter")) {
                    System.out.println(player.usePrompter());
                } else {
                    if (session.submitAnswer(answer)) {
                        if (session.isSessionCompleted()) {
                            return "Correct! You've answered all questions correctly. You can now take a crystal using the 'take' command.";
                        }
                        System.out.println("Correct!");
                        break;
                    } else {
                        System.out.println("Incorrect answer. Try again or use the 'prompter' command for hints.");
                    }
                }
            }
        }
        return "All questions answered!";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
