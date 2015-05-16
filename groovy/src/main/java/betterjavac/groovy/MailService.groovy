package betterjavac.groovy

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j

/**
 * @author Ivo Houbrechts
 */
@CompileStatic
//tag::logging[]
@Slf4j
class MailService {
    void sendMail() {
        log.trace("expensive call: ${expensive()}")
//end::logging[]
        log.info("calling expensive ${expensive()}")
    }

    private String expensive() {
        sleep(5000)
        return "expensive"
    }

    static void main(String[] args) {
        new MailService().sendMail()
    }

    //tag::lazy[]
    @Lazy
    List servers = createServers()
    volatile List threadSafe = createServers()
    //end::lazy[]

    private List createServers() {
        return null;
    }
}
