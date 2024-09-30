
package who_wants_to_be_a_millionaire;

import java.util.ArrayList;


public class FileOperations {
    
    private FileIO fileIO;
    
    public FileOperations()
    {
        fileIO = new FileIO();
    }
    
    // Generate a list of Question objects from a text file of questions, and return that list
    public ArrayList<Question> ParseQuestionsFromFile(String filename)
    {
        ArrayList<Question> questions = new ArrayList<Question>();
        
        ArrayList<String> questionFile = new ArrayList<String>();
        fileIO.ReadFile(filename).lines().forEach(s -> questionFile.add(s));
        
        // Expected question format
        //
        // --QUESTION--
        // Difficulty: EASY (EASY, MEDIUM or HARD)
        // Question text
        // A) answer a
        // B) answer b
        // C) answer c
        // D) answer d
        // Correct: A (A, B, C or D)
        //
        
        // Parse through file until end
        for (int i = 0; i < questionFile.size(); i++)
        {
            String line = questionFile.get(i);
            
            if (line.equals("--QUESTION--") && i < (questionFile.size() +  7))
            {
                Question question = new Question();
                
                // Difficulty
                i++;
                line = questionFile.get(i);
                question.setDifficulty(line);
                
                // Question Text
                i++;
                line = questionFile.get(i);
                question.setQuestionText(line);
                
                // Answer Options
                i++; // A
                line = questionFile.get(i);
                question.setAnswerA(line);
                
                i++; // B
                line = questionFile.get(i);
                question.setAnswerB(line);
                
                i++; // C
                line = questionFile.get(i);
                question.setAnswerC(line);
                
                i++; // D
                line = questionFile.get(i);
                question.setAnswerD(line);
                
                // Correct Answer
                i++;
                line = questionFile.get(i);
                question.setCorrectAnswer(line);
                
                // Add finished question to list
                questions.add(question);
            }
        }
        
        
        return questions;
    }
    
    // Loads comments and responses for Regis from a text file
    public Regis ParseRegisFromFile(String filename)
    {
        ArrayList<String> regisFile = new ArrayList<String>();
        fileIO.ReadFile(filename).lines().forEach(s -> regisFile.add(s));
        
        // Expected Regis format
        //
        // --Identifier--
        // Regis text
        
        // List of identifier headers:
        //
        // Intro
        // Outro
        // Flair
        // Correct
        // Incorrect
        // No
        
        Regis regis = new Regis();
        
        ArrayList<String> intros = new ArrayList<String>();
        ArrayList<String> outros = new ArrayList<String>();
        ArrayList<String> flairs = new ArrayList<String>();
        ArrayList<String> corrects = new ArrayList<String>();
        ArrayList<String> incorrects = new ArrayList<String>();
        ArrayList<String> nos = new ArrayList<String>();
        
        // Create lists from file
        for (int i = 0; i < regisFile.size(); i++)
        {
            String line = regisFile.get(i);
            
            if (line.equals("--Intro--") && i < (regisFile.size() +  1))
            {
                i++;
                line = regisFile.get(i);
                intros.add(line);
            }
            
            if (line.equals("--Outro--") && i < (regisFile.size() +  1))
            {
                i++;
                line = regisFile.get(i);
                outros.add(line);
            }
            
            if (line.equals("--Flair--") && i < (regisFile.size() +  1))
            {
                i++;
                line = regisFile.get(i);
                flairs.add(line);
            }
            
            if (line.equals("--Correct--") && i < (regisFile.size() +  1))
            {
                i++;
                line = regisFile.get(i);
                corrects.add(line);
            }
            
            if (line.equals("--Incorrect--") && i < (regisFile.size() +  1))
            {
                i++;
                line = regisFile.get(i);
                incorrects.add(line);
            }
            
            if (line.equals("--No--") && i < (regisFile.size() +  1))
            {
                i++;
                line = regisFile.get(i);
                nos.add(line);
            }
        }
        
        // Backup messages for Regis if none are found in file
        if (intros.isEmpty())
        {
            intros.add("Regis couldn't find an intro");
        }
        if (outros.isEmpty())
        {
            outros.add("Regis couldn't find an outro");
        }
        if (flairs.isEmpty())
        {
            flairs.add("Regis couldn't find a flair message");
        }
        if (corrects.isEmpty())
        {
            corrects.add("Regis couldn't find a correct message");
        }
        if (incorrects.isEmpty())
        {
            incorrects.add("Regis couldn't find an incorrect message");
        }
        if (nos.isEmpty())
        {
            nos.add("Regis couldn't find a no message");
        }
        
        // Load messages into Regis
        regis.setIntros(SendToRegis(intros));
        regis.setOutros(SendToRegis(outros));
        regis.setFlairs(SendToRegis(flairs));
        regis.setCorrects(SendToRegis(corrects));
        regis.setIncorrects(SendToRegis(incorrects));
        regis.setNos(SendToRegis(nos));
        
        return regis;
    }
    
    // Convert list to array to send to Regis
    private String[] SendToRegis(ArrayList<String> list)
    {
        String[] arr = new String[list.size()];
        
        for (int i = 0; i < list.size(); i++)
        {
            arr[i] = list.get(i);
        }
        
        return arr;
    }
    
    // Writes the given log string to file
    public void ExportGameLog(String filename, String log, GameState state)
    {
        String export = "GAME LOG\n\n";
        export += "QUESTIONS ANSWERED: " + state.getQuestionNum() + "\n";
        export += "MONEY WON: " + state.getCurrentWinnings() + "\n\n";
        
        export += log;
        
        fileIO.WriteFile(filename, export);
    }
}
