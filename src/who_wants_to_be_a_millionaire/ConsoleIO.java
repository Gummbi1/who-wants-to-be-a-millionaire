
package who_wants_to_be_a_millionaire;


import java.util.Scanner;

public class ConsoleIO {

    private String log = "";

    // Return logged game
    public String getLog() {
        return log;
    }
    
    //input string ---> output it to console and log
    public void outputText(String text) {
        System.out.println(text);
        log += text + "\n";
    }

    //get user input return it as all uppercase
    public String inputText() {
        String inputText = getLine();
        String Ans = "";

        String[] validLetInput = {"A", "B", "C", "D"};
        String[] validNumInput = {"1", "2", "3", "4", "5"};
        String[] validYesInput = {"Y","5"};
        String[] validNoInput = {"N"};

        if (inputError(inputText, validLetInput)) {
            Ans = finalAns();
        }
        if (inputError(inputText, validNumInput)) {
            return inputText;
        }
        if (inputError(Ans, validYesInput)) {
            return inputText;
        }
        if (inputError(Ans, validNoInput)) {
            return "N";
        }
        return "ERROR";
    }

    // Get user input, return it and mirror to log
    public String getLine() {
        Scanner scanner = new Scanner(System.in);
        String inputText = scanner.nextLine();
        inputText = inputText.toUpperCase();
        log += inputText + "\n";
        return inputText;
    }

    //Checks valid input
    private boolean inputError(String inputText, String[] allowedInputs) {

        for (int i = 0; i < allowedInputs.length; i++) {
            if (inputText.equals(allowedInputs[i])) {
                return true;
            }
        }
        return false;

    }

    //"Is that your final answer?"
    public String finalAns() {
      
        outputText("Is that your final answer? Y/N");
        
        return getLine();

    }

}
