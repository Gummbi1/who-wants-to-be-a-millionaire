
package who_wants_to_be_a_millionaire;

import java.util.ArrayList;
import java.util.Random;

public class QuestionHandler {
    
    private ArrayList<Question> masterList;
    private ArrayList<Question> currentGameSubset;
    
        
    // Generates a list of all possible questions, and an empty list for the current game
    public QuestionHandler(ArrayList<Question> masterList)
    {
        this.masterList = new ArrayList<Question>(masterList);
        
        currentGameSubset = new ArrayList<Question>();
    }
    
    // Populates a list with questions for the current game with easy, medium and hard questions
    // Easy     ||  The number of easy difficulty questions to add
    // Medium   ||  The number of medium difficulty questions to add
    // Hard     ||  The number of hard difficulty questions to add
    public void GenerateCurrentGameSubset(int numEasy, int numMedium, int numHard)
    {
        // Create pools of available questions
        ArrayList<Question> poolEasy = new ArrayList<Question>(GeneratePool("EASY"));
        ArrayList<Question> poolMedium = new ArrayList<Question>(GeneratePool("MEDIUM"));
        ArrayList<Question> poolHard = new ArrayList<Question>(GeneratePool("HARD"));

        // Delete contents of subset if not empty
        if (!currentGameSubset.isEmpty())
        {
            currentGameSubset.clear();
        }
        
        // Add random questions from each pool in order
        AddFromPool(poolEasy, numEasy);
        AddFromPool(poolMedium, numMedium);
        AddFromPool(poolHard, numHard);
    }
    
    // Adds all questions of a given difficulty to a subset from the master list
    private ArrayList<Question> GeneratePool(String difficulty)
    {
        ArrayList<Question> pool = new ArrayList<Question>();
        
        masterList.forEach(q -> {
        if (q.getDifficulty().equals(difficulty))
        {
            pool.add(q);
        }
        });
        
        return pool;
    }
    
    // Adds random questions from a specified pool to the current game subset
    private void AddFromPool(ArrayList<Question> pool, int num)
    {
        Random random = new Random();
        
        for (int i = 0; i < num; i++)
        {
            if (!pool.isEmpty())
            {
                int index = random.nextInt(pool.size());
                currentGameSubset.add(pool.get(index));
                pool.remove(index);
            }
            else
            {
                currentGameSubset.add(new Question());  // Blank question if not enough questions are found in master list
            }
        }
    }
    
    // 
    public Question GetNextQuestion(int num)
    {
        return currentGameSubset.get(num);
    }
    
    
}
