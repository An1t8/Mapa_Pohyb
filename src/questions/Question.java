package questions;

import java.io.Serializable;

/**
 * The questions.Question class represents a question with a correct answer and optional hints.
 */
public class Question implements Serializable {

    private String questionText;
    private String correctAnswer;

    public Question(String questionText, String correctAnswer) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
    }


    /**
     * Gets the question text.
     * @return The question text.
     */
    public String getQuestionText(){
        return questionText;
    }


    /**
     * Checks if a given answer is correct.
     * @param answer The answer to check.
     * @return True if the answer is correct, false otherwise.
     */

    public boolean isCorrect(String answer) {
        return correctAnswer.equalsIgnoreCase(answer.trim());
    }



    /**
     * Gets the correct answer to the question.
     * @return The correct answer.
     */
    public String getCorrectAnswer() {
        return correctAnswer;
    }



}
