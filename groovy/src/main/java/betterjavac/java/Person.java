package betterjavac.java;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

/**
 * @author Ivo Houbrechts
 */

//tag::traits[]
public class Person extends Entity implements Observable {
    @Override
    public void addListener(InvalidationListener listener) {
        //impl
    }

    @Override
    public void removeListener(InvalidationListener listener) {
        //impl
    }
}
