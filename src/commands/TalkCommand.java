package commands;

import game.GalacticSailor;
import game.PlanetGateKeeper;
import questions.Question;
import questions.QuestionSession;

import java.io.Serializable;
import java.util.Scanner;

/**
 * A command that allows the player to talk to the PGK and answer questions.
 * The player must answer all questions correctly before they can take a crystal.
 */
public class TalkCommand extends Command implements Serializable {

    private GalacticSailor player;

    Scanner sc = new Scanner(System.in);


    /**
     * Constructs the commands.TalkCommand with the given game.GalacticSailor and game.PlanetGateKeeper.
     * @param player The player attempting to talk to the PGK and answer questions.
     */
    public TalkCommand(GalacticSailor player) {
        this.player = player;
    }


    /**
     * Executes the commands.TalkCommand, which involves interacting with the PGK to answer questions.
     * If the player has already answered all questions correctly, they can collect a crystal.
     * Players can use the 'prompter' command for hints.
     * @return A string message describing the outcome of the interaction, such as completing the questions or collecting a crystal.
     */
    @Override
    public String execute() {
        PlanetGateKeeper pgk = player.getCurrentPGK();

        if (pgk == null) {
            return "There's no one to talk to on this planet.";
        }

        QuestionSession session = player.getCurrentSession();

        if (session == null) {
            session = new QuestionSession(pgk, player);
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

            System.out.println("questions.Question: " + currentQuestion.getQuestionText());

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
