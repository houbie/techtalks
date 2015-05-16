package betterjavac.groovy

import groovy.transform.CompileStatic

/**
 * @author Ivo Houbrechts
 */
@CompileStatic
    //tag::public[]
class Webservice {
    String url
    String user
    String password
    private HttpURLConnection connection
    //end::public[]
}
