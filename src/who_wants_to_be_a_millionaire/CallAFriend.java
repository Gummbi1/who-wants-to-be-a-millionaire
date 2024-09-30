
package who_wants_to_be_a_millionaire;

import java.util.ArrayList;
import java.util.Random;


public class CallAFriend extends Lifeline {

    public CallAFriend() 
    {
        super();
    }
    
    // Call A Friend
    // Specify a friend who will select one of the answers to a question with 80% confidence
    
    @Override
    protected final String Respond(Question question)
    {
        String response = "Your friend believes the correct answer is: ";
        
        Random rand = new Random();

        // 80% chance to respond correctly
        if (rand.nextInt(100) >= 80)
        {
            response += question.getCorrectAnswer();
        }
        // 20% chance to respond with a random wrong answer
        else
        {
            ArrayList<String> badAnswers = new ArrayList<String>();

            badAnswers.add("A");
            badAnswers.add("B");
            badAnswers.add("C");
            badAnswers.add("D");

            badAnswers.remove(question.getCorrectAnswer());

            response += badAnswers.get(rand.nextInt(3));
        }
        
        return response;
    }
    
    
    
}
