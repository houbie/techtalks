package betterjavac.groovy

import groovy.transform.CompileStatic

/**
 * @author Ivo Houbrechts
 */
@CompileStatic
public class Message {
    //tag::properties[]
    String body
    //end::properties[]

    //tag::propertiesOverride[]
    String subject

    void setSubject(String subject) {
        this.subject = subject.toUpperCase()
    }
    //end::propertiesOverride[]

    int getLength() {
        return subject.length()
    }
}
