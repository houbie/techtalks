package betterjavac.java;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author Ivo Houbrechts
 */
public class MailService {
    //tag::logging[]
    static final Logger logger = LoggerFactory.getLogger(MailService.class);

    public void sendMail() {
        if (logger.isTraceEnabled()) {
            logger.trace("expensive call: {}", expensive());
        }
        //end::logging[]
    }

    private String expensive() {
        logger.info("in expensive");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "expensive";
    }

    public static void main(String[] args) {
        new MailService().sendMail();
        debugLambda();
    }

    //tag::lazy[]
    private List servers;

    public List getServers() {
        if (servers == null) {
            servers = createServers();
        }
        return servers;
    }
    //end::lazy[]


    private List createServers() {
        return null;
    }


    private static void debugLambda() {
        List<String> strings = Lists.newArrayList("one", "two");
        strings.stream().anyMatch((s) -> {
                    logger.info("checking string s");
                    return s.contains("o");
                }
        );
    }

}
