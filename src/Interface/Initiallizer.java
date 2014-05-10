package Interface;

import BayesClassifier.BayesClassifier;
import BayesClassifier.Classifier;
import java.util.Arrays;

public class Initiallizer {
    
    String[] positiveText;
    String[] negativeText;
    String[] unknownText1;

    public String Builder() {

        final Classifier<String, String> bayes =
                new BayesClassifier<>();
        
        bayes.learn("positive", Arrays.asList(positiveText));

        
        bayes.learn("negative", Arrays.asList(negativeText));
        
        String result = bayes.classify(Arrays.asList(unknownText1)).getCategory();

        System.out.println(result);

        bayes.setMemoryCapacity(500);
        return result;
    }

    public Initiallizer(String[] positiveText, String[] negativeText, String[] unknownText1) {
        this.positiveText = positiveText;
        this.negativeText = negativeText;
        this.unknownText1 = unknownText1;
    }
}
