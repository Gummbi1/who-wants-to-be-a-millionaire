
package who_wants_to_be_a_millionaire;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class FileIO {
    //test5777
    public FileIO()
    {
        //test33
    }
    
    // Reads a file from filename specified and returns entire contents as a string
    public String ReadFile(String filename)
    {
        try
        {
            FileReader reader = new FileReader(filename);
            BufferedReader inputStream = new BufferedReader(reader);
            
            String line;
            String output = "";
            
            while((line = inputStream.readLine()) != null)
            {
                output += line;
                output += "\n";
            }
            
            inputStream.close();
            return output;
        }
    
        catch(FileNotFoundException e)
        {
            return "File not found.";
        }
        catch(IOException e)
        {
            return "Error reading from file.";
        }
    }
    
    // Writes a string to a file specified by filename, and returns true if successful.
    // The file is overwritten rather than appended.
    public boolean WriteFile(String filename, String toWrite)
    {
        try
        {
            PrintWriter pw = new PrintWriter(new FileOutputStream(filename));
            pw.print(toWrite);
            
            
            pw.close();
            
            // Return true if successful
            return true;
        }
        catch(FileNotFoundException e)
        {
            // Return false if write failed
            return false;
        }
    }
    
    
}
