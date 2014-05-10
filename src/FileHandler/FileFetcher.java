package FileHandler;

import Interface.Initiallizer;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Shivam Tiwari
 */
public class FileFetcher {
    public void getFile() throws FileNotFoundException, UnsupportedEncodingException, IOException{
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the folder in which you wish the output file to be generated -");
        String line = sc.nextLine();
        
        PrintWriter writer = new PrintWriter(line + "\\output.csv", "UTF-8");
        
        System.out.println("Enter the address of the training data (must be a CSV file) -");
        line = sc.nextLine();
        
        FileReader fis = new FileReader(line);
        BufferedReader br = new BufferedReader(fis);
        
        System.out.println("Enter the address of the testing data (must be a CSV file) -");
        line = sc.nextLine();
        
        FileReader fis2 = new FileReader(line);
        BufferedReader br2 = new BufferedReader(fis2);
        
        String positiveTrainData = "";
        String negativeTrainData = "";
        String testLine;
        
        Pattern patternObj = Pattern.compile("Yes");
       	
        System.out.println("Training system on following data - ");
        
        while((line = br.readLine()) != null){
            
            System.out.println(line);
            
            Matcher matcherObj = patternObj.matcher(line);
            
            if(matcherObj.find()){
                
                positiveTrainData += "," + line;
            }
            else{
                
                negativeTrainData += "," + line;
            }
        }
        
        System.out.println("Testing on following data - ");
        
        while((line = br2.readLine()) != null){
            
            System.out.println(line);
            
            testLine = line;
            
            Initiallizer se = new Initiallizer(positiveTrainData.split(","),negativeTrainData.split(","),testLine.split(","));
            
            if(se.Builder().equals("positive")){
                
                writer.println(testLine + "," + "Yes");
            }
            else{
                
                writer.println(testLine + "," + "No");
            }
        }
        
        writer.close();
    }
}
