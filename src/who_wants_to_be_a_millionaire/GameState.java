
package who_wants_to_be_a_millionaire;

public class GameState {
     private int questionAns; 
     private boolean gameOver;
     private int currentWinnings;
     private int nextWinnings;
     private int bankedWinnings; 
     private int[] prizeList = {0, 100, 200, 300, 500, 1000, 2000, 4000, 8000, 16000, 32000, 64000, 125000, 250000, 500000, 1000000};
     private String[] textPrizeList = {"0", "100", "200", "300", "500", "1,000", "2,000", "4,000", "8,000", "16,000", "32,000", "64,000", "125,000", "250,000", "500,000", "1,000,000"};
     
      //blake
   //refreshes/starts game
   public GameState(){
     questionAns = 0; 
     gameOver = false;
     getCurrentWinnings();
     getNextWinnings();
     checkBanked();
    
   }
   
   // Export the prize list as a string with markers
   public String GetPrizeListAsText()
   {
       String prizeText = "";
       
       for (int i = textPrizeList.length - 1; i >= 0; i--)
       {
           if (i < 10)
           {
               prizeText += "  ";
           }
           prizeText += i;
           if (i <= questionAns)
           {
               prizeText += " | ";
           }
           else
           {
               prizeText += "   ";
           }
           prizeText += " $";
           prizeText += textPrizeList[i];
           if (i != 0)
           {
               prizeText += "\n";
           }
       }
       
       return prizeText;
   }

   //get what question number player is on
   public int getQuestionNum () {
       return questionAns;
}
   //returns gameover
   public boolean isGameOver(){
       return gameOver;
   }
   //increment questionNum 
   public void incrementQuestion(){
       questionAns++;
       setCurrentWinnings();
       checkBanked();
       if (questionAns == 15){
           setGameOver();
       }
   }
   //current winnings
   public int getCurrentWinnings(){
      
       return currentWinnings;
   }
      public void setCurrentWinnings(){
       currentWinnings = prizeList[questionAns];
   }
      public int getNextWinnings(){
       if (questionAns == 15)
          {
              nextWinnings = prizeList[questionAns];
          }
          else
          {
              nextWinnings = prizeList[questionAns+1];
          }
       
       return nextWinnings;
   } 
   //Gets bankedWinnings
    public int getBankedWinnings(){
       return bankedWinnings;
   }
    
    //Updates the banked if one of the question milesolid have been met
    private void checkBanked(){
        if(questionAns == 5|| questionAns == 10|| questionAns == 15){
            bankedWinnings = prizeList[questionAns];
        }
        //makes sure last game's banked winning are not carried over
        if(questionAns < 5){
            bankedWinnings = prizeList[0];
        }
    }
   //incorrect question
   public void setGameOver(){
       gameOver = true;
       currentWinnings = bankedWinnings;
    }
   //Walkaway
   public void walkAway(){
       gameOver = true;
       }
}