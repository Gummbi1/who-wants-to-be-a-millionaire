
package who_wants_to_be_a_millionaire;

/**
 *
 * @author GGPC
 */
public class Who_Wants_To_Be_A_Millionaire {

    public static void main(String[] args) {
        
        // Record the state of the game, and create handlers for console and file interaction
        GameState state = new GameState();
        FileOperations fileOps = new FileOperations();
        ConsoleIO consoleIO = new ConsoleIO();
        
        // Generate a handler for the questions
        QuestionHandler qList = new QuestionHandler(fileOps.ParseQuestionsFromFile("Questions.txt"));
        qList.GenerateCurrentGameSubset(5, 5, 5);   // Easy, Medium, Hard questions
        
        // Create a host to interact with the player
        Regis regis = fileOps.ParseRegisFromFile("regis.txt");
        
        // Create lifelines
        CallAFriend lifelineCallAFriend = new CallAFriend();
        AskTheAudience lifelineAskTheAudience = new AskTheAudience();
        FiftyFifty lifelineFiftyFifty = new FiftyFifty();
        
        // Host reads an intro to the game
        consoleIO.outputText(regis.readIntro());
        
        // Main game loop
        while(state.isGameOver() == false)
        {
            // Ask Question
            Question question = qList.GetNextQuestion(state.getQuestionNum());
            consoleIO.outputText(regis.readQuestion(state.getQuestionNum(), state.getNextWinnings(), question));
            
            // Give Options
            consoleIO.outputText(regis.readOptions(lifelineCallAFriend.available, lifelineFiftyFifty.available, lifelineAskTheAudience.available, state.getCurrentWinnings()));
            
            // Get Player Response
            String input = consoleIO.inputText();

            switch (input)
            {
                // Answer Question
                case "A":
                case "B":
                case "C":
                case "D":
                    if (question.IsCorrect(input))
                    {
                        // Advance to next question if answer is correct
                        state.incrementQuestion();
                        consoleIO.outputText(regis.readCorrect(state.getCurrentWinnings(), state.getBankedWinnings()));
                    }
                    else
                    {
                        // End the game if an incorrect answer is given
                        state.setGameOver();
                        consoleIO.outputText(regis.readIncorrect(state.getCurrentWinnings(), question));
                    }
                    break;
                    
                // Use Lifeline 
                case "1":   // Call A Friend
                    consoleIO.outputText(lifelineCallAFriend.UseLifeline(question));
                    break;
                case "2":   // Ask The Audience
                    consoleIO.outputText(lifelineAskTheAudience.UseLifeline(question));
                    break;
                case "3":   // 50/50
                    consoleIO.outputText(lifelineFiftyFifty.UseLifeline(question));
                    break;
                    
                // Walk Away or exit
                case "4":
                case "5":
                    state.walkAway();
                    break;
                // Repeat question if player does not want to answer yet
                case "N":
                    consoleIO.outputText(regis.readNo());
                    break;
                // Prompt player for valid input
                case "ERROR":
                    consoleIO.outputText("Please input a valid selection.");
                    break;
                default:
                    break;
            }
            consoleIO.outputText("\n\n\n"); // Spacing before next question
        }   
            
        // Host reads outro and announces final winnings
        consoleIO.outputText(regis.readOutro(state.getCurrentWinnings()));
        
        // Send last game to file
        fileOps.ExportGameLog("log.txt", consoleIO.getLog(), state);
        
        consoleIO.outputText("Program exited.");
    }

    
}
