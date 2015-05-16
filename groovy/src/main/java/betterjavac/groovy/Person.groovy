package betterjavac.groovy

import betterjavac.java.Entity
import groovy.transform.CompileStatic

/**
 * @author Ivo Houbrechts
 */
@CompileStatic
//tag::traits[]
class Person extends Entity implements Observable {
}
