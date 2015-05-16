package betterjavac.groovy

import groovy.transform.CompileStatic
import javafx.beans.InvalidationListener

/**
 * @author Ivo Houbrechts
 */
@CompileStatic
//tag::traits[]
trait Observable implements javafx.beans.Observable {
    private Set<InvalidationListener> listeners = []

    @Override
    void addListener(InvalidationListener listener) {
        listeners << listener
    }

    @Override
    void removeListener(InvalidationListener listener) {
        listeners.remove(listener)
    }
}