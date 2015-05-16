package betterjavac.groovy

import spock.lang.Specification

/**
 * @author Ivo Houbrechts
 */
class UserSpec extends Specification {
    def "check the fullname"() {
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
