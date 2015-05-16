package betterjavac.groovy

import groovy.transform.CompileStatic

/**
 * @author Ivo Houbrechts
 */
@CompileStatic
//tag::dataClass[]
class Address {
    String street
    String zip
    String city
}
