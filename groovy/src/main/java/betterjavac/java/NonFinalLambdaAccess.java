package betterjavac.java;

import java.util.Arrays;
import java.util.List;

/**
 * @author Ivo Houbrechts
 */
public class NonFinalLambdaAccess {
    public static final List<String> GROOVY_WORDS = Arrays.asList("groovy", "grails", "gradle");

    public boolean isGroovy(String message) {
        return GROOVY_WORDS.stream().anyMatch(message::contains);
    }

    public static void main(String[] args) {
        assert !new NonFinalLambdaAccess().isGroovy("java");
        assert new NonFinalLambdaAccess().isGroovy("groovy");
    }
}
