package betterjavac.groovy

import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author Ivo Houbrechts
 */
class SpockExampleSpec extends Specification {
    //tag::spockData[]
    @Unroll
    def "minimum of #a and #b is #c"() {
        expect:
        Math.min(a, b) == c

        where:
        a | b || c
        3 | 7 || 3
        5 | 4 || 3
        9 | 9 || 9
    }
    //end::spockData[]

    @Unroll
    def "power asserts"() {
        def users = [new User(userName: 'Ivo', address: new Address(city: 'Kasterlee')), new User(userName: 'Wim', address: new Address(city: 'Mechelen'))]

        expect:
        users[1]?.address?.city == 'Kasterlee'
    }


}
