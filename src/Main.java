
import FileHandler.FileFetcher;
import java.io.IOException;

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
