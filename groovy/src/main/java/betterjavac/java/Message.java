package betterjavac.java;

/**
 * @author Ivo Houbrechts
 */
public class Message {
    private String subject;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject.toUpperCase();
    }

    //tag::properties[]
    private String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
   //end::properties[]

    int getLength() {
        return subject.length();
    }
}
