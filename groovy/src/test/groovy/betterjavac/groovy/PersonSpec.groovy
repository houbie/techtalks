package betterjavac.groovy

import spock.lang.Specification

/**
 * @author Ivo Houbrechts
 */
class PersonSpec extends Specification {
    def "AddListener"() {

        new Person().addListener { println "invalidated called" }
        expect:
        true
    }
}
