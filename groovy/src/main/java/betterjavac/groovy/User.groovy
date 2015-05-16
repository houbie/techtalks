package betterjavac.groovy

import groovy.transform.Canonical
import groovy.transform.CompileStatic

@CompileStatic
@Canonical
class User {
    String userName
    String firstName
    String lastName
    Address address
    boolean enabled;
    boolean provisioned;

    String getFullName() {
        if (firstName && lastName) {
            return "$firstName $lastName";
        }
        return firstName ?: lastName ?: '';
    }
}
