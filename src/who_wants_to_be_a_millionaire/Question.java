
package who_wants_to_be_a_millionaire;

public class Question {
 
    
    private String difficulty;
    private String questionText;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private String correctAnswer;
    
    public Question()
    {
        difficulty = "UNUSED";
        questionText = "This question is blank!";
        answerA = "No answers given";
        answerB = "No answers given";
        answerC = "No answers given";
        answerD = "No answers given";
        correctAnswer = "A";
    }
    
    // Expected question format
        //
        // --QUESTION--
        // EASY (EASY, MEDIUM or HARD)
        // Question text
        // A) answer a
        // B) answer b
        // C) answer c
        // D) answer d
        // A (Correct Answer - A, B, C or D)
        //

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty.toUpperCase();
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getAnswerA() {
        return answerA;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer.toUpperCase();
    }
    
    // Returns true if the provided answer matches the correct answer
    public boolean IsCorrect(String answer)
    {
        return getCorrectAnswer().equals(answer);
    }
}
