package betterjavac.java

import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author Ivo Houbrechts
 */
class UserSpec extends Specification {
    @Unroll
    def "check the fullname for #user.firstName #user.lastName"() {
        expect:
        user.fullName == fullName

        where:
        user                                           | fullName
        new User(firstName: 'first', lastName: 'last') | 'first last'
        new User(firstName: '', lastName: 'last')      | 'last'
        new User(lastName: 'last')                     | 'last'
        new User(firstName: 'first', lastName: '')     | 'first'
        new User(firstName: 'first')                   | 'first'
        new User()                                     | ''
    }
}
