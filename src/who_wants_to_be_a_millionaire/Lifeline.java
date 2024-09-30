
package who_wants_to_be_a_millionaire;


public abstract class Lifeline {
    
    // Available is whether the lifeline can be used or has been used already
    protected boolean available;
    
    // All lifelines start available
    public Lifeline()
    {
        available = true;
    }
    
    // Any class can see availability
    public boolean IsAvailable()
    {
        return available;
    }
    
    // Only child classes can use the lifeline
    protected void SetUsed()
    {
        available = false;
    }
    
    // Any class can reset the lifeline
    public void Reset()
    {
        available = true;
    }

    // Use the lifeline if it is available, otherwise respond with an error
    public String UseLifeline(Question question)
    {
        String response;
        
        if (IsAvailable())
        {
            response = Respond(question);
            
            // Use up the lifeline
            SetUsed();
        }
        else
        {
            response = "You've already used this lifeline!";
        }

        return response;
    }
    
    // Usage of the lifeline implemented by child class
    protected abstract String Respond(Question question);

}
