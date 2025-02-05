/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package who_wants_to_be_a_millionaire;

/**
 *
 * @author GGPC
 */
public interface GameLogic {
    
        // Generate subset of easy, medium and hard questions
        void GenerateQuestionPool();
        
        // Output an intro from Regis to the chosen output
        void ReadIntro();
        
        // Run main gameplay loop
        void GameLoop();
        
        // Ask the player the next question
        void AskQuestion();
        
        // Get a response from the player, and check if it is correct
        void CheckPlayerAnswer(String input);
        
        // Output a response from Regis if the player chooses to retract their final answer
        void ReadNo();
        
        // Use a lifeline for the current question
        void UseLifelineCallAFriend();
        void UseLifelineAskTheAudience();
        void UseLifeline5050();
        
        // End the game by walking away or exiting to menu
        void WalkAway();
        
        // Output an outro and final winnings from Regis to the chosen output
        void ReadOutro();
        
}
