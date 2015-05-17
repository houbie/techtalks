package betterjavac.java;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.springframework.beans.factory.xml.DefaultBeanDefinitionDocumentReader;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Sets.newHashSet;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

/**
 * @author Ivo Houbrechts
 */
public class JavaSnippets {

    static int calculateScore(){
        return 0;
    }

    static DefaultBeanDefinitionDocumentReader createDocumentReader(){
        return new DefaultBeanDefinitionDocumentReader();
    }

    public static void main(String[] args) {
        String string = "";
        Object object = new Object();
        int number = 0;
        Collection collection = newArrayList();

        User user = new User();
        user.setFirstName("Ivo");
        user.setLastName("Houbrechts");

        //tag::semicolon[]
        int x = 1;
        double sinus = Math.sin(x);
        //end::semicolon[]

        String message=
        //tag::stringInterpolation[]
        "Hello " + user.getFirstName() + ", your score is " +
                calculateScore() + " points.";
        //end::stringInterpolation[]

        //tag::stringEscapes[]
        String html = "<div class=\"ruler\"/>";
        String regexp = "\\\\\""; // \"
        //end::stringEscapes[]

        //tag::stringMultiline[]
        String multiLine = "<note>\n" +
                "    <to>Tove</to>\n" +
                "    <from>Jani</from>\n" +
                "    <heading>Reminder</heading>\n" +
                "    <body>Don't forget me this weekend!</body>\n" +
                "</note>";
        //end::stringMultiline[]

        //tag::nullsafe[]
        String city = null;
        if (user != null && user.getAddress() != null) {
            city = user.getAddress().getCity();
        }
        //end::nullsafe[]

        //tag::default[]
        String s = (isNotEmpty(user.getUserName())) ? user.getUserName() : "default";
        //end::default[]

        //tag::literal[]
        List<Integer> numbers = newArrayList(1, 2, 3);
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Groovy", 9);
        scores.put("Java", 7);
        //end::literal[]

        //tag::namedArguments[]
        User ivo = new User("houbie", "Ivo", "Houbrechts", true, false);

        User u = new User();
        u.setUserName("houbie");
        u.setFirstName("Ivo");
        u.setLastName("Houbrechts");
        u.setEnabled(true);
        u.setProvisioned(false);
        //end::namedArguments[]

        String type= "";
        String lhs= "";
        String rhs= "";
        //tag::equals[]
        if ("TOP".equals(type)) {}

        if (!Objects.equals(lhs , rhs)) {}
        //end::equals[]

        //tag::truth[]
        if (object != null) {}

        if (isNotEmpty(string)) {}

        if (collection != null && !collection.isEmpty()) {}
        //end::truth[]

        Order order= new Order();
        List<Order> orders= newArrayList(order);
        //tag::spread[]
        double amount = 0;
        for (OrderLine orderLine : order.getOrderLines()) {
            amount += orderLine.getAmount();
        }

        Set<Address> deliveryAddresses = newHashSet();
        for (Order o : orders) {
            for (OrderLine orderLine : o.getOrderLines()) {
                deliveryAddresses.add(orderLine.getAddress());
            }
        }
        //end::spread[]

        //tag::regexp[]
        Pattern pattern = Pattern.compile("(\\d)+");
        Matcher matcher = Pattern.compile("(\\d)+").matcher("2.0.12");
        boolean matches = Pattern.compile("(\\d)+").matcher("2.0.12").matches();
        //end::regexp[]

        String text;
        //tag::switch[]
        if (object instanceof Number) {
            text = "it's a number";
        } else if (Pattern.compile("(\\d)+").matcher(object.toString()).matches()) {
            text = "it matches the pattern";
        } else if (newArrayList("Java", "JavaScript").contains(object)) {
            text = "it's in the list";
        }
        //end::switch[]

        Mail mail = new Mail();
        //tag::properties[]
        String subject = mail.getMessage().getSubject();
        mail.getMessage().setBody("Hello");
        //end::properties[]

        //tag::range[]
        int count = 1;
        while (count <= 10) {
            //do stuff
            count++;
        }
        //end::range[]

        List allUsers= newArrayList(new User());
        List enabledUsers= newArrayList(new User());
        Collection disabledUsers;
        //tag::operator1[]
        //javadoc of CollectionUtils.subtract:
        // Returns a new Collection containing a - b
        disabledUsers= CollectionUtils.subtract(allUsers, enabledUsers);
        //end::operator1[]

        StringBuilder stringBuilder = new StringBuilder();
        Map map = new HashMap();
        List list = newArrayList();
        //tag::operator2[]
        stringBuilder.append("Hello ").append(user).append('!');

        map.put("foo", "bar");
        map.get("foo");

        list.set(3, "bazz");
        list.get(3);
        //end::operator2[]

        //tag::inference[]
        Point point = new Point(10, 33);

        DefaultBeanDefinitionDocumentReader documentReader=
                new DefaultBeanDefinitionDocumentReader();
        DefaultBeanDefinitionDocumentReader defaultBeanDefinitionDocumentReader=
                createDocumentReader();

        if (object instanceof User){
            ((User)user).getFirstName(); // no cast necessary in java 8
        }
        //end::inference[]

        int[] array = {};
        int size;
        Predicate predicate = new Predicate() {
            @Override
            public boolean evaluate(Object object) {
                return false;
            }
        };
        //tag::fix[]
        size = array.length;
        size = string.length();
        size = collection.size();

        CollectionUtils.find(collection, predicate);
        //end::fix[]

    }

    //tag::defaultArguments[]
    public void save() {
        save("csv");
    }

    public void save(String format) {
        save(format, false);
    }

    public void save(String format, boolean minify) {
        save(format, minify, false);
    }

    public void save(String format, boolean minify, boolean prettify) {
        //implementation
    }
    //end::defaultArguments[]

}

