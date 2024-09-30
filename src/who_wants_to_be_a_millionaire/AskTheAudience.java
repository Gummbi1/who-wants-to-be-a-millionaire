
package who_wants_to_be_a_millionaire;

import java.util.Random;

public class AskTheAudience extends Lifeline {

    public AskTheAudience() 
    {
        super();
    }
    
    // Ask The Audience
    // Audience responds with a percentage distribution of what they believe is correct
    
    @Override
    protected final String Respond(Question question)
    {
        String response = "The audience is in favour of these answers:\n";
        
        // Answer percentages
        int o1;
        int o2;
        int o3;
        int o4;
        
        Random rand = new Random();
        
        // Mode 0   70% chance   Greatly favour correct answer
        // Mode 1    5% chance   Greatly favour random incorrect answer, slightly favour correct answer
        // Mode 2   25% chance   Favour both the correct answer and a random incorrect answer
        int mode = SelectMode(70,5,25);
        
        switch(mode)
        {
            case 0:
                o1 = 60 + rand.nextInt(40);
                o2 = rand.nextInt((101 - o1)/3);
                o3 = rand.nextInt((101 - o1 - o2)/2);
                o4 = 100 - o1 - o2 - o3;
                
                // o1 is correct
                response += Assign(question, o1, new int[]{o2,o3,o4});
                
                break;
            case 1:
                o1 = 50 + rand.nextInt(36);
                o2 = 15 + rand.nextInt(((86 - o1)/3));
                o3 = rand.nextInt((101 - o1 - o2)/2);
                o4 = 100 - o1 - o2 - o3;
                
                // o2 is correct
                response += Assign(question, o2, new int[]{o1,o3,o4});
                
                break;
            case 2:
                o1 = 30 + rand.nextInt(18);
                o2 = 30 + rand.nextInt(18);
                o3 = rand.nextInt((101 - o1 - o2)/2);
                o4 = 100 - o1 - o2 - o3;
                
                // o1 is correct
                response += Assign(question, o1, new int[]{o2,o3,o4});
                break;
        }
        
        return response;
    }
    
    // Selects a mode according to percentage chances
    private int SelectMode(int mode0, int mode1, int mode2)
    {
        Random rand = new Random();
        
        // 0 - 99
        int select = rand.nextInt(100);
        
        // Default mode
        int mode = 0;
        
        int range0High = mode0;
        int range1High = mode0 + mode1;
        
        if (select < range0High)
        {
            mode = 0;
        }
        else if (select >= range0High && select < range1High)
        {
            mode = 1;
        }
        else if (select >= range1High)
        {
            mode = 2;
        }
        
        return mode;
    }
    
    // Assigns specified guess value for correct answer, and incorrect values to incorrect answers
    private String Assign(Question q, int correct, int[] incorrect)
    {
        String output = "";
        
        String[] answers = new String[]{"A", "B", "C", "D"};
        
        int i = 0;
        
        for (int j = 0; j < 4; j++)
        {
            output += answers[j] + ") ";
            if (q.IsCorrect(answers[j]))
            {
                output += correct;
            }
            else
            {
                output += incorrect[i];
                i++;
            }
            output += "%\n";
        }
        
        return output;
    }
    
}
