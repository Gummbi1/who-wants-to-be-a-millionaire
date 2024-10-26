/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package who_wants_to_be_a_millionaire;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class QuestionTest {

    private Question question;

    @Before
    public void setup() {
        question = new Question();
        question.setDifficulty("EASY");
        question.setQuestionText("What color is the sky?");
        question.setAnswerA("Blue");
        question.setAnswerB("Red");
        question.setAnswerC("Yellow");
        question.setAnswerD("Green");
        question.setCorrectAnswer("A");
    }

    
    //Tests to make sure the Question loads correctly
    @Test
    public void testQuestionInitialization() {
        assertEquals("Question text incorrect", "What color is the sky?", question.getQuestionText());
        assertEquals("AnswerA incorrect", "Blue", question.getAnswerA());
        assertEquals("AnswerB incorrect", "Red", question.getAnswerB());
        assertEquals("AnswerC incorrect", "Yellow", question.getAnswerC());
        assertEquals("AnswerD incorrect", "Green", question.getAnswerD());
        assertEquals("Correct answer incorrect", "A", question.getCorrectAnswer());
        
    }
}
    