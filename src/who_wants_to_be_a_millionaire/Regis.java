package who_wants_to_be_a_millionaire;

import java.util.Random;

public class Regis {

    Random rand = new Random();

    private String[] intros;
    private String[] outros;
    private String[] flairs;
    private String[] corrects;
    private String[] incorrects;
    private String[] nos;

    //Take question object and add flair 
    public String readQuestion( Question question) {

        
        String fullQuestion;
        fullQuestion = question.getQuestionText();

        return fullQuestion;
    }
    
    public String readFlair(int questionNum, int nextWinnings){
        
        int select = 0;

        //Select first flair message on the first question, otherwise select random other flair message
        if (questionNum == 0)
        {
            select = 0;
        }
        else if (flairs.length > 1)
        {
            select = rand.nextInt(flairs.length - 1) + 1;
        }
        String fullFlair = flairs[select] + " "+ nextWinnings + " dollars!";
        
        return fullFlair;
              
    }

    public String readOptions(boolean lifeFriend, boolean life5050, boolean lifeAsk, int currentWinnings) {
        String fullOptions;
        fullOptions = "----------------------------------------------\n"
                + "1. Lifeline: Phone-a-Friend";
        if (lifeFriend == false) {
            fullOptions += "[USED]";
        }

        fullOptions += "\n" + "2. Lifeline: Ask the Audience";
        if (lifeAsk == false) {
            fullOptions += "[USED]";
        }

        fullOptions += "\n" + "3. Lifeline: 50-50";
        if (life5050 == false) {
            fullOptions += "[USED]";
        }

        fullOptions += "\n" + "4. Walkaway with $" + currentWinnings;
        
        fullOptions += "\n" + "5. Exit";

        return fullOptions;
    }

    //intro
    public String readIntro(int questionNum, int nextWinnings) {
        String fullIntro;
        int select = rand.nextInt(intros.length);
        fullIntro = intros[select] + "\n\n"+readFlair(questionNum,nextWinnings);
        return fullIntro;
    }

    //outro
    public String readOutro(int currentWinnings) {
        int select = rand.nextInt(outros.length);
        String fullOutro;
        fullOutro = outros[select] + "\n $" + currentWinnings;
        return fullOutro;
    }
  

    public String readCorrect(int currentWinnings, int bankedWinnings, int questionNum, int nextWinnings) {

        int select = rand.nextInt(corrects.length);
        String fullCorrect;
        if (currentWinnings == bankedWinnings) {
            fullCorrect = "That's one of the checkpoints! " + currentWinnings + " dollars are in your bank!";
        } else {
            fullCorrect = corrects[select] + " $" + currentWinnings;
        }
        fullCorrect+="\n\n"+readFlair(questionNum,nextWinnings);
        
        return fullCorrect;
    }

    public String readIncorrect(int currentWinnings, Question question) {

        int select = rand.nextInt(incorrects.length);
        String fullIncorrect;

        fullIncorrect = incorrects[select] + " $" + currentWinnings + ".\n" + "\nCorrect Answer: " + question.getCorrectAnswer();

        return fullIncorrect;
    }

    public String readNo() {
        int select = rand.nextInt(nos.length);
        return nos[select];
    }

    /**
     * @param intros the intros to set
     */
    public void setIntros(String[] intros) {
        this.intros = intros;
    }

    /**
     * @param outros the outros to set
     */
    public void setOutros(String[] outros) {
        this.outros = outros;
    }

    /**
     * @param flairs the flairs to set
     */
    public void setFlairs(String[] flairs) {
        this.flairs = flairs;
    }

    /**
     * @param corrects the corrects to set
     */
    public void setCorrects(String[] corrects) {
        this.corrects = corrects;
    }

    /**
     * @param incorrects the incorrect to set
     */
    public void setIncorrects(String[] incorrects) {
        this.incorrects = incorrects;
    }

    /**
     * @param nos the nos to set
     */
    public void setNos(String[] nos) {
        this.nos = nos;
    }

}
