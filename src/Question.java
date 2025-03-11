import java.util.ArrayList;
import java.util.List;


public class Question {

    private String questionText;
    private String correctAnswer;
    private List<String> hints;
    private boolean wasHintUsed;

    public Question(String questionText, String correctAnswer, List<String> hints) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.hints = hints;
        this.wasHintUsed = false;
    }

    public String getQuestionText(){
        return questionText;
    }


    public boolean isCorrect(String answer) {
        return correctAnswer.equalsIgnoreCase(answer.trim());
    }

    public List<String> getHints() {
        wasHintUsed = true;
        return hints;
    }

    public String getFirstHint() {
        return "";
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }



}
