
import FileHandler.FileFetcher;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Shivam Tiwari
 */
public class Main {
    public static void main(String[] args) throws IOException{
        
        System.out.println("Bayes Classification In Java!");
        
        FileFetcher fh = new FileFetcher();
        
        fh.getFile();
    }
}
