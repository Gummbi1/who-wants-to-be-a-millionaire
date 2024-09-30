
package who_wants_to_be_a_millionaire;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class FiftyFifty extends Lifeline {

    public FiftyFifty() 
    {
        super();
        // Test comment for commit
    }
    
    // Fifty Fifty
    // Removes two incorrect options at random
    
    @Override
    protected final String Respond(Question question)
    {
        String output = "The correct answer is one of the following: ";
        
        Random rand = new Random();
        
        ArrayList<String> answers = new ArrayList<String>();
        answers.add("A");
        answers.add("B");
        answers.add("C");
        answers.add("D");
        
        // Remove correct answer to add back later
        answers.remove(question.getCorrectAnswer());
        
        // Remove two incorrect answers
        answers.remove(rand.nextInt(answers.size()));
        answers.remove(rand.nextInt(answers.size()));
        
        // Add correct answer back
        answers.add(question.getCorrectAnswer());
        
        // Sort answers to original order
        Collections.sort(answers);
        
        for (int i = 0; i < answers.size(); i++)
        {
            output += "\n" + answers.get(i);
        }
        
        return output;
    }
}
